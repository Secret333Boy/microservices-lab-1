/**
 * @author Eugene Pashkovsky <pashkovskiy.eugen@gmail.com>
 */

import * as dotenv from "dotenv";
import { Sequelize } from "sequelize";
import path from "path";
dotenv.config({ path: path.resolve(__dirname, "../../.env") });
const databaseName = process.env.POSTGRES_DB || "postgres";
const username = process.env.POSTGRES_USER || "postgres";
const password = process.env.POSTGRES_PASSWORD || "postgres";
const sequelize = new Sequelize(databaseName, username, password, {
  host: process.env.AUTH_POSTGRES_SERVICE_HOST,
  dialect: "postgres",
  port: Number(process.env.AUTH_POSTGRES_SERVICE_PORT),
  sync: { alter: process.env.ALTER_SYNC === "true" },
  logging: false,
});

export default sequelize;
