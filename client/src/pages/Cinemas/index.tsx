import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../page.css";
import "../../custom-button.css";
import Movie from "../../components/Movie/Movie";
import ApiService from "../../services/ApiService";

const CinemasPage = () => {
  interface Cinema {
    id: number;
    name: string;
    location: string;
  }
  const [cinemas, setCinemas] = useState<Cinema[]>([]);

  useEffect(() => {
    const getCinemas = async () => {
      const { data } = await ApiService.get<Cinema[]>(
        `${process.env.REACT_APP_BACKEND_URL}/api/movie-management/cinemas`
      );

      if (!data) return;

      setCinemas(data);
    };
    getCinemas();
  }, []);

  return (
    <div>
      <div className="parent">
        <button className="round-4">
          <Link to="/">To home</Link>
        </button>
      </div>

      <div className="movie-container">
        {cinemas.map(({ id, name, location }) => (
          <Movie key={id} name={name} description={location} id={id} />
        ))}
      </div>
    </div>
  );
};

export default CinemasPage;
