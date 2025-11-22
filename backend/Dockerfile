FROM eclipse-temurin:24-jre-alpine
WORKDIR /app
# La source doit inclure 'app/' car le jar est dans le sous-module
COPY app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]