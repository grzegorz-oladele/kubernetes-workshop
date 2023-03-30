FROM maven:3.8.6-amazoncorretto-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-al2-jdk
WORKDIR /app
COPY --from=builder /app/target/client-0.0.1-SNAPSHOT.jar client-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "client-0.0.1-SNAPSHOT.jar"]