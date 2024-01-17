# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS builder

# Set the working directory
WORKDIR /app

# Copy only the POM file to cache dependencies
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY src src

# Build the application
RUN mvn package -DskipTests

# Stage 2: Create a lightweight image with the JAR
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Install PostgreSQL client and server
RUN apt-get update && apt-get install -y postgresql postgresql-contrib

# Copy the PostgreSQL configuration files
COPY postgresql.conf /etc/postgresql/
COPY pg_hba.conf /etc/postgresql/

# Expose PostgreSQL port
EXPOSE 5432

# Start PostgreSQL and then your application
CMD service postgresql start && java -jar app.jar