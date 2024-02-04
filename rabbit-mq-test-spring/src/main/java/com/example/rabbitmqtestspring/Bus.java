package com.example.rabbitmqtestspring;

import org.slf4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.slf4j.LoggerFactory.getLogger;

@Component
public class Bus {
    private static final Logger LOGGER = getLogger(Bus.class);

    @RabbitListener(queues = "testQueue")
    public void processMessage(Message message) {
        LOGGER.info("Получено сообщение \"" + new String(message.getBody(), UTF_8) + "\"");
    }
}


