# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and permission setup
COPY mvnw .
COPY .mvn .mvn

# Copy the rest of the project files
COPY pom.xml .
COPY src ./src

# Make mvnw executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Second stage to create a smaller final image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=0 /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
