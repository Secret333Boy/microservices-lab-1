import React from "react";
import { Link } from "react-router-dom";

const HomePage = () => {
  return (
    <div>
      <Link to="/movies">Movies</Link>
      <Link to="/cinemas">Cinemas</Link>
    </div>
  );
};

export default HomePage;
