package pl.radomiej.dockerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerProjectApplication {

    public static void main(String[] args) {
        for (Object o : System.getenv().entrySet()) {
            System.out.println(o);
        }
        SpringApplication.run(DockerProjectApplication.class, args);
    }
}
