package org.malex.producer.consumer;

import org.malex.producer.dto.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumer.class);

    @RabbitListener(queues={"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(Job job){
        LOGGER.info(String.format("Received JSON message -> %s", job.toString()));
    }
}
