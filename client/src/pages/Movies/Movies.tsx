import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../page.css";
import "../../custom-button.css";
import Movie from "../../components/Movie/Movie";
import ApiService from "../../services/ApiService";

const Movies = () => {
  interface Movie {
    id: number;
    name: string;
    description: string;
  }
  const [movies, setMovies] = useState<Movie[]>([]);

  useEffect(() => {
    (async () => {
      const { data } = await ApiService.get<Movie[]>(
        "/movie-management/movies"
      );
      if (!data) return;
      setMovies(data);
    })();
  }, []);

  return (
    <div>
      <div className="parent">
        <button className="round-4">
          <Link to="/">To home</Link>
        </button>
      </div>

      <div className="movie-container">
        {movies.map(({ id, name, description }) => (
          <Movie key={id} name={name} description={description} id={id} />
        ))}
      </div>
    </div>
  );
};

export default Movies;
