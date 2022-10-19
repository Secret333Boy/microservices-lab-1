/**
 * @author Eugene Pashkovsky <pashkovskiy.eugen@gmail.com>
 */

import bcrypt from "bcrypt";
import sequelize from "../repository/sequelize";
import TokenService from "./TokenService";
import User from "../models/sequelize/User";
import UserDTO from "../models/interfaces/UserDTO";
import TokenStore from "../models/sequelize/TokenStore";
import Validator from "../utils/Validator";
import ApiError from "../models/ApiError";
import { request } from "undici";

if (!process.env.EMAIL_SERVICE_HOST || !process.env.EMAIL_SERVICE_PORT)
  throw new Error("Kubernetes: email service unknown");
const emailURL = `http://${process.env.EMAIL_SERVICE_HOST}:${process.env.EMAIL_SERVICE_PORT}/api/email/send-activation`;
export default class AuthService {
  private tokenService: TokenService = new TokenService();

  public async validateCredentials(email: string, password: string) {
    const validator = new Validator();
    validator.validateEmail(email).validatePassword(password).submit();
  }

  public async register(email: string, password: string) {
    await this.validateCredentials(email, password);
    if (await User.findOne({ where: { email } }))
      throw ApiError.badRequest("User with this email already exists");
    const hash = await bcrypt.hash(password, <string>process.env.PASSWORD_SALT);
    const transaction = await sequelize.transaction();
    const user = await User.create({ email, hash }, { transaction });
    try {
      console.log(emailURL);
      const { statusCode: messageStatus, body } = await request(emailURL, {
        method: "POST",
        body: JSON.stringify({
          email_to: user.email,
          activation_link: `${
            process.env.GATEWAY_URL
          }/api/auth/activate/${user.activationId}`,
        }),
        headers: {
          "Content-Type": "application/json",
          "api-secret": <string>process.env.API_SECRET,
        },
      });
      console.error(await body.text());
      if (messageStatus !== 200) throw new Error('Mail service issue');
    } catch (e) {
      await transaction.rollback();
      throw e;
    }
    await transaction.commit();
    return this.tokenService.generateTokens(user);
  }

  public async login(email: string, password: string) {
    await this.validateCredentials(email, password);
    const hash = await bcrypt.hash(password, <string>process.env.PASSWORD_SALT);
    const user = await User.findOne({ where: { email, hash } });
    if (!user) throw ApiError.unauthorized("Invalid email or password");
    return this.tokenService.generateTokens(user);
  }

  public async logout(token: string) {
    if (!token) throw ApiError.badRequest("No token in cookies found");
    const decoded = this.tokenService.decodeToken<UserDTO>(token);
    await TokenStore.destroy({ where: { id: decoded.id } });
  }

  public async validate(token: string, isRefreshToken = false) {
    if (!token) throw ApiError.unauthorized("No token provided");
    const secret = isRefreshToken
      ? <string>process.env.REFRESH_TOKEN_SECRET
      : <string>process.env.ACCESS_TOKEN_SECRET;
    const decoded = this.tokenService.validateToken<UserDTO>(token, secret);
    const userInDB = await User.findOne({
      where: { id: decoded.id, email: decoded.email, hash: decoded.hash },
    });
    if (!userInDB) throw ApiError.unauthorized("Invalid token");
    if (!userInDB.isActivated)
      throw ApiError.unauthorized("User is not activated yet");
    return decoded;
  }

  public async refresh(token: string) {
    if (!token) throw ApiError.badRequest("No token in cookies found");
    const decoded = await this.validate(token, true);
    return this.tokenService.generateTokens(decoded);
  }

  public async activate(activationId: string) {
    if (!activationId) throw ApiError.badRequest("No id provided");
    let user;
    try {
      user = await User.findOne({ where: { activationId } });
    } catch {
      throw ApiError.badRequest("Invalid id");
    }
    if (!user) throw ApiError.badRequest("User is not in DB");
    if (user.isActivated)
      throw ApiError.badRequest("User is already activated");
    await user.update({ isActivated: true });
  }
}
