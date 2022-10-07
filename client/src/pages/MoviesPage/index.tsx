import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../page.css";
import "../../custom-button.css";
import Movie from "../../components/Movie";
import { Interface } from "readline";

const MoviesPage = () => {
  interface movie {id:number, name:string, description:string};
  const [movies, setMovies] = useState<movie[]>([]);

  useEffect(() => {
    const getMovies = async () => {
      const response = await fetch("http://192.168.49.2/api/movies");
      setMovies(await response.json());
      console.log();
    };
    getMovies();
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

export default MoviesPage;
