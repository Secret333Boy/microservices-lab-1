import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CinemasPage from "./pages/CinemasPage";
import HomePage from "./pages/HomePage";
import MoviesPage from "./pages/MoviesPage";

const Router = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/cinemas" element={<CinemasPage />} />
        <Route path="/movies" element={<MoviesPage />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Router;
