package org.malex.producer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues={"${rabbitmq.queue.name}"})
    public void consumer(String message){
        LOGGER.info(String.format("Received message -> %s", message));

    }
}
