FROM node:18-alpine

WORKDIR /app

COPY ./migrations ./migrations

COPY ./database.json .

RUN npm i -g db-migrate db-migrate-pg
