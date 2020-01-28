FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/my-blog-4.0.0-SNAPSHOT.jar my-blog-4.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/my-blog-4.0.0-SNAPSHOT.jar"]