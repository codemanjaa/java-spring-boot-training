#FROM maven:3.8.3-jdk-11
#WORKDIR /app
#COPY pom.xml /app
#COPY src /app/src
#ENV MAVEN_OPTS="-classpath /usr/share/maven/lib/maven3-eventspy-3.8.3.jar"
#RUN apt-get update && \
#    apt-get install -y maven && \
#    mvn clean package
#EXPOSE 8080
#CMD ["java", "-jar", "target/myapp.jar"]
FROM openjdk:17-jdk-alpine
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]


