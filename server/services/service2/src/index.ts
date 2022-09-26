import express from "express";
import cluster from "cluster";
import os from "os";

const PORT = process.env.PORT || 82;

const app = express();

app.get("/ping", (_req, res) => {
  res.json("Hello from service 2");
});

app.get("*", (req, res) => {
  res.status(404).send();
});

if (cluster.isPrimary) {
  for (let i = 0; i < os.cpus().length - 1; i++) {
    cluster.fork();
  }
} else {
  app.listen(PORT, () => {
    console.log(`Server has been started on port ${PORT}`);
  });
}
