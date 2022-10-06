FROM openjdk:17-alpine
ADD . /src
WORKDIR /src
RUN ./mvnw clean package -DskipTests
CMD ["java","-jar","./target/result.jar"]