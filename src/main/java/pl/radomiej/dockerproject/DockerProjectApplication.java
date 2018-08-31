package pl.radomiej.dockerproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import pl.radomiej.dockerproject.services.redis.RedisEventBusService;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class DockerProjectApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisEventBusService.class);

    public static void main(String[] args) throws InterruptedException {
        for (Object o : System.getenv().entrySet()) {
            System.out.println(o);
        }
        ApplicationContext ctx = SpringApplication.run(DockerProjectApplication.class, args);
        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);

        LOGGER.info("Sending message...");
        template.convertAndSend("chat", "Hello from Redis!");

        latch.await();

        System.exit(0);

    }
}
