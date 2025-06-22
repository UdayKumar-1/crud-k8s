# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/UserService-0.0.1-SNAPSHOT.jar /app/UserService-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "/app/UserService-0.0.1-SNAPSHOT.jar"]
