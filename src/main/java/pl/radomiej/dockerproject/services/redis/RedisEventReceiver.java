package pl.radomiej.dockerproject.services.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

public class RedisEventReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisEventReceiver.class);

    private CountDownLatch latch;

    @Autowired
    public RedisEventReceiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        latch.countDown();
    }
}
