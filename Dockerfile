FROM openjdk:17-alpine

LABEL maintainer="sehmusaydogdu47@gmail.com"

EXPOSE 8080

ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]