FROM openjdk:17-jdk-slim
WORKDIR /app

COPY target/LabsBackend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080