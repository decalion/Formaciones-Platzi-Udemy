FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY ./05_SpringbootServidorDocker-0.0.1-SNAPSHOT.jar /app.jar
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active-default", "/app.jar"]