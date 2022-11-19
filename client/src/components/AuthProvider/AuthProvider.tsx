import React, { FC, ReactNode, useEffect, useState } from 'react';
import { Navigate } from 'react-router-dom';
import AccountContext from '../../contexts/AccountContext';
import ApiService from '../../services/ApiService';
import { Account } from '../../types';

export interface AuthProviderProps {
  children: ReactNode;
}

const AuthProvider: FC<AuthProviderProps> = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [isLoaded, setIsLoaded] = useState(false);
  const [account, setAccount] = useState<Account>();

  useEffect(() => {
    (async () => {
      const { ok } = await ApiService.get('/auth/validate');

      if (!ok) {
        const { data, ok: refreshOk } = await ApiService.get<{
          accessToken: string;
        }>('/auth/refresh');
        if (!data || !refreshOk) return setIsLoaded(true);
        localStorage.setItem('accessToken', data.accessToken);
      }

      const { data } = await ApiService.get<Account>('/auth/account');
      setAccount(data);
      setIsAuthenticated(true);
      setIsLoaded(true);
    })();
  }, []);

  if (!isLoaded) return <></>;

  if (!isAuthenticated || !account) {
    return <Navigate to="/login" />;
  }

  return (
    <AccountContext.Provider value={account}>
      {children}
    </AccountContext.Provider>
  );
};

export default AuthProvider;
