FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY ./demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]