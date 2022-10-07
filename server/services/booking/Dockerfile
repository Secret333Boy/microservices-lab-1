FROM maven:3.8-openjdk-17

WORKDIR /app

COPY pom.xml /app/pom.xml

COPY src /app/src

EXPOSE 8084

RUN ["mvn", "clean", "package"]

CMD ["mvn", "spring-boot:run"]
