FROM openjdk:21-jdk-slim

EXPOSE 8080

ADD target/egovf-sra.jar egovf-sra.jar

ENTRYPOINT ["java", "-jar", "egovf-sra.jar"]
