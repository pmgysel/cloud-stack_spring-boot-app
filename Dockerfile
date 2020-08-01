FROM maven:3.5.2-jdk-8-alpine

MAINTAINER Philipp Gysel <pmgysel@ucdavis.edu>

EXPOSE 8080 8080

WORKDIR "/app"
ADD . /app
RUN mvn clean install

CMD ["java", "-jar", "target/spring-boot-app-0.0.1-SNAPSHOT.jar"]