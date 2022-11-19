import { createContext } from 'react';
import { Account } from '../types';

const defaultValue: Account = { id: '', email: '' };

const AccountContext = createContext<Account>(defaultValue);

export default AccountContext;
