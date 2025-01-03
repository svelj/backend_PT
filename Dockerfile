FROM openjdk:17-jdk-alpine
COPY /home/runner/work/backend_PT/backend_PT/target/PocketTrack-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]