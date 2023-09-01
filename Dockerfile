FROM maven:3.8.3-openjdk-17 AS builder
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/  .
CMD ["java", "-jar","playlist-0.0.1-SNAPSHOT.jar"]
