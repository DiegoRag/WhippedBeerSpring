# Use an official Java runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app


# Copy the fat jar
COPY target/app-0.0.1-SNAPSHOT.jar app.jar



# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]