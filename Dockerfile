# Use a base image with JDK
FROM openjdk:22-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/BookTask-main-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
