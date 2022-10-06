/**
 * @author Eugene Pashkovsky <pashkovskiy.eugen@gmail.com>
 */

import {
  CreationOptional,
  InferAttributes,
  InferCreationAttributes,
  Model,
} from 'sequelize';

export default interface User
  extends Model<InferAttributes<User>, InferCreationAttributes<User>> {
  id: CreationOptional<string>;
  email: string;
  hash: string;
  isActivated: CreationOptional<boolean>;
  activationId: CreationOptional<string>;
}
