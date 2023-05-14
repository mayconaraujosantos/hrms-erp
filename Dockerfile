FROM amazoncorretto:17-alpine-jdk AS build

# Install Gradle
RUN apk add --no-cache gradle

# Copy project files to working directory
WORKDIR /app
COPY . .

# Build the application
RUN gradle build

# Use a lightweight base image for the production stage
FROM amazoncorretto:17-alpine-jdk

# Copy the jar file from the build stage
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Expose port 8080 and run the application
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]