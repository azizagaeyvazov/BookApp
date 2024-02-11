# Use an official Maven image as a parent image
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the application
RUN mvn clean install -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the current stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar .

# Expose the port the app runs on
EXPOSE 8080

# Define environment variable
ENV NAME World

# Run the application
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]