FROM node:18-alpine

WORKDIR /app

COPY ["package.json", "package-lock.json*", "tsoa.json", "tsconfig.json", "./"]

RUN npm install

COPY ./src ./src

RUN npm run build

EXPOSE 8082

CMD ["npm", "start"]