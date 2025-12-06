# Build
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /novanotes
COPY pom.xml .
COPY src ./src
RUN mvn -q -e -DskipTests package

#Run (we use Jre instead of JDK for only runtime needs)
FROM eclipse-temurin:17-jre
WORKDIR /novanotes
COPY --from=builder /novanotes/target/*.jar novanotes.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","novanotes.jar"]