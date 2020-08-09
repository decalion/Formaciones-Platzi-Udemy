FROM openjdk:8-jdk-alpine
EXPOSE 8081
COPY ./05_SpringbootClienteDocker-0.0.1-SNAPSHOT.jar /app.jar
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.jar"]