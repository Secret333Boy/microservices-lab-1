FROM node:16

WORKDIR /src

COPY . .

RUN npm i

RUN npm run build

EXPOSE 82

CMD ["npm", "start"]