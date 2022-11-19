import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import AuthProvider from "./components/AuthProvider";
import Cinemas from "./pages/Cinemas";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Movies from "./pages/Movies";
import Register from "./pages/Register";

const Router = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element={
            <AuthProvider>
              <Home />
            </AuthProvider>
          }
        />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route
          path="/cinemas"
          element={
            <AuthProvider>
              <Cinemas />
            </AuthProvider>
          }
        />
        <Route
          path="/movies"
          element={
            <AuthProvider>
              <Movies />
            </AuthProvider>
          }
        />
      </Routes>
    </BrowserRouter>
  );
};

export default Router;
