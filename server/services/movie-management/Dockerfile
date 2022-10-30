FROM maven:3.8-openjdk-17

WORKDIR app

COPY pom.xml /app/pom.xml

RUN ["mvn", "verify", "clean", "--fail-never"]

COPY src /app/src

EXPOSE 8081

RUN ["mvn", "install", "-DskipTests"]

CMD ["mvn", "spring-boot:run"]