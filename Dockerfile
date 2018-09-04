FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD 'target/docker-project-0.0.1-SNAPSHOT.jar' app.jar
#ADD 'run.sh' run.sh
EXPOSE 8080:8080
#ENTRYPOINT ["java","-XX:MaxRam=500m -Xms50m -Xmx250m -XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["java"]