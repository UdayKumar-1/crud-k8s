# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/CrudService-0.0.1-SNAPSHOT.jar /app/CrudService-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# run application
ENTRYPOINT ["java", "-jar", "/app/CrudService-0.0.1-SNAPSHOT.jar"]