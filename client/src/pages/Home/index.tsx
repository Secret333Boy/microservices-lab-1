import React from "react";
import { Link } from "react-router-dom";
import "../page.css";
import "../../custom-button.css";

const HomePage = () => {
  return (
    <div className="homepage">
      <div className="parent">
        <button className="round-4">
          <Link to="/movies">Movies</Link>
        </button>
      </div>
      <div className="parent">
        <button className="round-4">
          <Link to="/cinemas">Cinemas</Link>
        </button>
      </div>
    </div>
  );
};

export default HomePage;
