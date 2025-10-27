# 1. Use a small, optimized Java runtime image (Java 17 LTS)
FROM eclipse-temurin:17-jre-alpine

# 2. Add an argument to locate the JAR file created by Maven
ARG JAR_FILE=target/*.jar

# 3. Copy the compiled JAR into the container's root directory
COPY ${JAR_FILE} app.jar

# 4. Expose the port (8080 is default for Spring Boot)
EXPOSE 8080

# 5. Define the command to run the application when the container starts
ENTRYPOINT ["java","-jar","/app.jar"]