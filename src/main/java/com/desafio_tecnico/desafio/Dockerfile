FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
RUN useradd -ms /bin/bash spring
COPY --from=build /app/target/project-management.jar app.jar
RUN chown spring:spring /app.jar
USER spring
ENTRYPOINT ["java", "-jar", "/app.jar"]