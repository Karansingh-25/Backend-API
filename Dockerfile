# 1. Use a lightweight JRE base image (Java 17 LTS)
FROM eclipse-temurin:17-jre-alpine

# 2. Define environment variables for DB credentials (to be injected by cloud host)
#    These will be overridden at runtime (Render/Railway/other cloud platforms)
ENV SPRING_DATASOURCE_URL=jdbc:mysql://gateway01.ap-northeast.tidbcloud.com:4000/testdb?sslMode=REQUIRED
ENV SPRING_DATASOURCE_USERNAME=7houjKES5zLdnTk.root
ENV SPRING_DATASOURCE_PASSWORD=FaGuLDUZ5weYXrbP

# Optional: reduce memory usage for small free-tier containers
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# 3. Add an argument for the built JAR file (copied from Maven target/)
ARG JAR_FILE=target/*.jar

# 4. Copy the JAR into the container
COPY ${JAR_FILE} app.jar

# 5. Expose Spring Boot default port
EXPOSE 8080

# 6. Command to run the app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]
