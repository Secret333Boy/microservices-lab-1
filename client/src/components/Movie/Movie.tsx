import { Card } from "@mui/material";
import React from "react";

const Movie = ({
  id,
  name,
  description,
}: {
  id: number;
  name: string;
  description: string;
}) => {
  return (
    <Card>
      <div>{id}</div>
      <div>{name}</div>
      <div>{description}</div>
    </Card>
  );
};

export default Movie;
