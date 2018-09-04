package pl.radomiej.dockerproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import pl.radomiej.dockerproject.service.redis.RedisEventBusService;

@SpringBootApplication
public class DockerProjectApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisEventBusService.class);

    public static void main(String[] args) throws InterruptedException {
        //Hack for fast deployment in kubernatest app wizard
        String[] fixSingleArg = args;
        if(args.length == 1) fixSingleArg = args[0].split(" ");


        ApplicationContext ctx = SpringApplication.run(DockerProjectApplication.class, fixSingleArg);
        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);

        LOGGER.info("Sending message...");
        template.convertAndSend("chat", "Hello from Redis!");



    }
}
