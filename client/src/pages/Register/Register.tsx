import { Box, Button, TextField } from '@mui/material';
import React, { ChangeEvent, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import ApiService from '../../services/ApiService';

const Register = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    verifyPassword: '',
  });

  const handleFormDataChange = (e: ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const navigate = useNavigate();

  const handleRegister = async () => {
    const { data, ok } = await ApiService.post<{ accessToken: string }>(
      '/auth/register',
      {
        body: formData,
      }
    );

    if (!ok || !data) return;
    localStorage.setItem('accessToken', data.accessToken);
    navigate('/');
  };

  return (
    <Box
      sx={{
        width: '100%',
        minHeight: '100vh',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        flexDirection: 'column',
      }}
    >
      <form
        style={{
          minWidth: '50%',
          display: 'flex',
          flexDirection: 'column',
          gap: '10px',
        }}
      >
        <Box style={{ display: 'flex', gap: '10px' }}>
          <TextField
            id="firstName"
            name="firstName"
            label="firstName"
            variant="outlined"
            fullWidth
            value={formData.firstName}
            onChange={handleFormDataChange}
          />
          <TextField
            id="lastName"
            name="lastName"
            label="lastName"
            variant="outlined"
            fullWidth
            value={formData.lastName}
            onChange={handleFormDataChange}
          />
        </Box>
        <Box>
          <TextField
            id="email"
            name="email"
            label="email"
            variant="outlined"
            fullWidth
            value={formData.email}
            onChange={handleFormDataChange}
          />
        </Box>
        <Box>
          <TextField
            id="password"
            name="password"
            label="password"
            variant="outlined"
            type="password"
            fullWidth
            value={formData.password}
            onChange={handleFormDataChange}
          />
        </Box>
        <Box>
          <TextField
            id="verifyPassword"
            name="verifyPassword"
            label="repeat your password"
            variant="outlined"
            type="password"
            fullWidth
            value={formData.verifyPassword}
            onChange={handleFormDataChange}
          />
        </Box>
        <Button variant="contained" fullWidth onClick={handleRegister}>
          Register
        </Button>
      </form>
      <Link to="/login">Already have an account? Login now!</Link>
    </Box>
  );
};

export default Register;
