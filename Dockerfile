FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/vivinho-streams-0.0.1-SNAPSHOT.jar"]
