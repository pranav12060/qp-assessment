# Build Stage
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy project files
COPY . .

# Give execution permission to the Maven wrapper
RUN chmod +x ./mvnw

# Run Maven build
RUN ./mvnw clean package -DskipTests

# Run Stage - Use a lightweight image to run the built JAR
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/grocery-booking-api-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
