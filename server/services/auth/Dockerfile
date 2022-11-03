FROM node:18-alpine AS builder
WORKDIR /app
COPY ["package.json", "package-lock.json*", "tsoa.json", "tsconfig.json", "./"]
RUN npm install
COPY ./src ./src
RUN npm run build

FROM node:18-alpine AS production
WORKDIR /app
COPY package.json package.json
RUN npm install --omit=dev
COPY --from=builder /app/build ./build
EXPOSE 8082

CMD ["npm", "start"]