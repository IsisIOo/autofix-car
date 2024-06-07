FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} autofix-car.jar
ENTRYPOINT ["java", "-jar", "/autofix-car.jar"]