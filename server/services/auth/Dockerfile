FROM node:18-alpine

WORKDIR /src

COPY . .

RUN npm i

RUN npm run build

EXPOSE 8082

CMD ["npm", "start"]