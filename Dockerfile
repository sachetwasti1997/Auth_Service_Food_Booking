FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} authservice.jar

ENTRYPOINT [ "java", "-jar", "/authservice.jar" ]