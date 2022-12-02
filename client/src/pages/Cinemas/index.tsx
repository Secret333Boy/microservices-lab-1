import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../page.css";
import "../../custom-button.css";
import Movie from "../../components/Movie/Movie";
import ApiService from "../../services/ApiService";

const DATA = '[{"id":1,"name":"Cinema 1","location":"Location of the cinema 1"},{"id":2,"name":"Cinema 2","location":"Location of the cinema 2"},{"id":3,"name":"Cinema 3","location":"Location of the cinema 3"}]'

const CinemasPage = () => {
  interface Cinema {
    id: number;
    name: string;
    location: string;
  }
  const [cinemas, setCinemas] = useState<Cinema[]>([]);

  useEffect(() => {
    const getCinemas = async () => {
      const data = JSON.parse(DATA);
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
