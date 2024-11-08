FROM openjdk:21-jdk-slim

WORKDIR /app

RUN apt-get update && apt-get install -y maven

COPY pom.xml /app

RUN mvn install

COPY src /app/src

EXPOSE 8080

CMD ["mvn", "spring-boot:run", "--quiet"]
