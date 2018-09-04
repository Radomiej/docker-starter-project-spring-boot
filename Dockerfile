FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD 'target/docker-project-0.0.1-SNAPSHOT.jar' app.jar
EXPOSE 8080:8080
ENTRYPOINT [ "java", "-Xms50m", "-Xmx250m", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]
CMD ["--spring.redis.host=10.244.1.118", "--spring.redis.port=55555", "--spring.data.mongodb.host=10.0.230.141"]