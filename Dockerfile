# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim as builder

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and install dependencies
COPY pom.xml .
RUN ./mvnw dependency:go-offline

# Copy the source code into the container
COPY src /app/src

# Package the application
RUN ./mvnw clean package -DskipTests

# Create a new image from the OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar from the builder stage to the container
COPY --from=builder /app/target/bookmarker-api-*.jar /app/bookmarker-api.jar

# Expose port 8088
EXPOSE 8088

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/bookmarker-api.jar"]
