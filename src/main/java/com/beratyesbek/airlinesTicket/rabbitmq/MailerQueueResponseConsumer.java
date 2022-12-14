package com.beratyesbek.airlinesTicket.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MailerQueueResponseConsumer {

    @RabbitListener(queues = {"${queue.response.name}"})
    public void receive(@Payload String fileBody, @Headers Map<String, String> headers) {
        System.out.println(fileBody);
    }

}