package com.beratyesbek.airlinesTicket.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MailerQueueSender {

    private final RabbitTemplate queueSender;

    private Queue queue;

    public void send(String messages) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("ultima", "sim");
        Message message = new Message(messages.getBytes(), messageProperties);

        queueSender.send(this.queue.getName(), message);
    }
}
