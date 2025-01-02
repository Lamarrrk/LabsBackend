FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . /app
RUN apt-get update && apt-get install -y maven && mvn clean package
ENTRYPOINT ["java", "-jar", "target/LabsBackend-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080




