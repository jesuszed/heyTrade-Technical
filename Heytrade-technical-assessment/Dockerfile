FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/Heytrade-technical-assessment-1.0.jar
COPY ${JAR_FILE} Heytrade-technical-assessment-1.0.jar
WORKDIR /opt/app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Heytrade-technical-assessment-1.0.jar"]