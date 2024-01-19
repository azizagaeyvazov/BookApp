# Use the official OpenJDK base image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

# Install dependencies (if any) - adjust as needed
# RUN apt-get update && apt-get install -y <your-dependency>

# Expose the port your app runs on
EXPOSE 8090

# Define environment variables for database connection
ENV DB_URL=jdbc:postgresql://127.0.0.1:5433/Book
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=eyvazov313

# Command to run your application
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]