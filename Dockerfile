FROM adoptopenjdk/openjdk8-openj9:alpine-slim
VOLUME /tmp

ADD 'target/app.jar' app.jar
ADD target/thin.properties thin.properties

EXPOSE 8080:8080
ENTRYPOINT [ "java", "-XX:+UseSerialGC", "-Xss256k", "-Xmx32m", "-XX:MaxRAM=64m" ,"-XX:MaxDirectMemorySize=2M", "-XX:MaxRAMFraction=1", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar", "--thin.root=/m2" ]