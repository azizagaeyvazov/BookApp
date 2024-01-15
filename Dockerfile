FROM openjdk:21
COPY target/demo-0.0.1-SNAPSHOT.jar /temp/
WORKDIR /temp
ENTRYPOINT ["java","-jar",".target/demo-0.0.1-SNAPSHOT.jar"]