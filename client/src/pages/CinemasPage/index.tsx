import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../page.css";
import "../../custom-button.css";
import Movie from "../../components/Movie";

const CinemasPage = () => {
  interface cinema {id:number, name:string, location:string};
  const [movies, setMovies] = useState<cinema[]>([]);

  useEffect(() => {
    const getMovies = async () => {
      const response = await fetch("http://192.168.49.2/api/movies");
      setMovies(await response.json());
      console.log();
    };
    //getMovies();
    setMovies([
      {
        id: 1,
        name: "Movie 1",
        location: "Description of movie 1",
      },
      {
        id: 2,
        name: "Movie 2",
        location: "Description of movie 2",
      },
      {
        id: 1,
        name: "Movie 1",
        location: "Description of movie 1",
      },
      {
        id: 2,
        name: "Movie 2",
        location: "Description of movie 2",
      }, 
      {
        id: 1,
        name: "Movie 1",
        location: "Description of movie 1",
      },
      {
        id: 2,
        name: "Movie 2",
        location: "Description of movie 2",
      },
       
    ]);
  }, []);

  return (
    <div>
      <div className="parent">
        <button className="round-4">
          <Link to="/">To home</Link>
        </button>
      </div>
      
      <div className="movie-container">
        {movies.map(({ id, name, location }) => (
          <Movie key={id} name={name} description={location} id={id} />
        ))}
      </div>

    </div>
  );
};

export default CinemasPage;
