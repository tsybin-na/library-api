FROM openjdk:11
VOLUME /usr/src/app
COPY target/*.jar library-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/library-api-0.0.1-SNAPSHOT.jar"]