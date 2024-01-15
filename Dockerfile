FROM openjdk:21
COPY demo-0.0.1-SNAPSHOT.jar /temp/
WORKDIR /temp
ENTRYPOINT ["java", "-jar", "/temp/demo-0.0.1-SNAPSHOT.jar"]
