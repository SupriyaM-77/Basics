# Use an OpenJDK base image with the appropriate version (Java 17)
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the target folder into the container
COPY target/SpringData-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on (8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
