# Java 21 Image
FROM openjdk:22-ea-21-oracle

# Refer to Maven build -> finalName
ARG JAR_FILE=target/react-challenge-0.0.1.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
