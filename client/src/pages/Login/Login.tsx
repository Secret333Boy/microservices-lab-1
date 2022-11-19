import { Box, Button, TextField } from "@mui/material";
import React, { useState, ChangeEvent } from "react";
import { Link, useNavigate } from "react-router-dom";
import ApiService from "../../services/ApiService";

const Login = () => {
  const [formData, setFormData] = useState({ email: "", password: "" });

  const handleFormDataChange = (e: ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const navigate = useNavigate();

  const handleLogin = async () => {
    const { data: accessToken, ok } = await ApiService.post<string>(
      "/auth/login",
      {
        body: formData,
      }
    );

    if (!ok || !accessToken) return;
    localStorage.setItem("accessToken", accessToken);
    navigate("/");
  };

  return (
    <Box
      sx={{
        width: "100%",
        minHeight: "100vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        flexDirection: "column",
      }}
    >
      <form
        style={{
          minWidth: "50%",
          display: "flex",
          flexDirection: "column",
          gap: "10px",
        }}
      >
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
        <Button variant="contained" fullWidth onClick={handleLogin}>
          Login
        </Button>
      </form>
      <Link to="/register">Don&apos;t have an account yet? Register now!</Link>
    </Box>
  );
};

export default Login;
