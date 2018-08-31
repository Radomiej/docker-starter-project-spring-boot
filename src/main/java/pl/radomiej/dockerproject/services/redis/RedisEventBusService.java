package pl.radomiej.dockerproject.services.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;

//@Service
public class RedisEventBusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisEventBusService.class);

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    RedisEventReceiver receiver(CountDownLatch latch) {
        return new RedisEventReceiver(latch);
    }

    @Bean
    MessageListenerAdapter listenerAdapter(RedisEventReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

        return container;
    }


    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private CountDownLatch latch;


}
