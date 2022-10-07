import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../page.css";
import "../../custom-button.css";
import Movie from "../../components/Movie";

const CinemasPage = () => {
  interface cinema {id:number, name:string, location:string};
  const [cinemas, setCinemas] = useState<cinema[]>([]);

  useEffect(() => {
    const getCinemas = async () => {
      const response = await fetch("http://192.168.49.2/api/cinemas");
      setCinemas(await response.json());
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
