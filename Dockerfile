# Use an official OpenJDK runtime as a parent image
FROM openjdk:21

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

# Specify the command to run on container start
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]