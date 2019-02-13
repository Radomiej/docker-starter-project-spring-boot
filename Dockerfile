FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD 'target/docker-project-0.0.1-SNAPSHOT.jar' app.jar
EXPOSE 8080:8080
ENTRYPOINT [ "java", "-Xss256k", "-Xmx32m", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]