package pl.radomiej.dockerproject.service.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisEventReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisEventReceiver.class);


    public RedisEventReceiver() {
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
    }
}
