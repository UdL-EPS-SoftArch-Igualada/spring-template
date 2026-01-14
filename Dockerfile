# Build stage
FROM maven:3.9.12-ibm-semeru-21-noble AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B -q dependency:go-offline
COPY src ./src
RUN mvn -B -q package -DskipTests

# Runtime stage
FROM ibm-semeru-runtimes:open-21-jre-noble
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
