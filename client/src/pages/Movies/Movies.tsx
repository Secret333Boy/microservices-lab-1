import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../page.css";
import "../../custom-button.css";
import Movie from "../../components/Movie/Movie";
import ApiService from "../../services/ApiService";


const DATA = '[{"id":1,"name":"Movie 1","description":"Description of movie 1","imagePath":"/src/main/resources/images/image1.jpg","image":null,"duration":8581906},{"id":2,"name":"Movie 2","description":"Description of movie 2","imagePath":"/src/main/resources/images/image2.jpg","image":null,"duration":25066626},{"id":3,"name":"Movie 3","description":"Description of movie 3","imagePath":"/src/main/resources/images/image3.jpg","image":null,"duration":57216649},{"id":4,"name":"Movie 4","description":"Description of movie 4","imagePath":"/src/main/resources/images/image4.jpg","image":null,"duration":61166929},{"id":5,"name":"Movie 5","description":"Description of movie 5","imagePath":"/src/main/resources/images/image5.jpg","image":null,"duration":30642564}]';
const Movies = () => {
  interface Movie {
    id: number;
    name: string;
    description: string;
  }
  const [movies, setMovies] = useState<Movie[]>([]);

  useEffect(() => {
    (async () => {

      const data = JSON.parse(DATA);
      // const { data } = await ApiService.get<Movie[]>(
      //   "/movie-management/movies"
      // );
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
