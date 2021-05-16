FROM openjdk:latest
VOLUME /tmp
ADD target/ReceptBack-1.0.jar app.jar
ENTRYPOINT [ "sh", "-c", "java --enable-preview -jar /app.jar" ]