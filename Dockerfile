FROM openjdk:17-alpine
COPY ./target/esercitazione-card-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","esercitazione-card-0.0.1-SNAPSHOT.jar"]
