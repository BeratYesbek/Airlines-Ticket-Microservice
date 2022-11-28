package com.beratyesbek.airlinesTicket.mailerService;

import com.beratyesbek.airlinesTicket.rabbitmq.MailerQueueSender;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MailerServiceImpl implements NotifyService {

    private final MailerQueueSender mailerQueueSender;

    public MailerServiceImpl(MailerQueueSender mailerQueueSender) {
        this.mailerQueueSender = mailerQueueSender;
    }

    @Override
    public void sendNotify(String message, Map<String,Object> headers) {
        mailerQueueSender.send(message,headers);
    }
}
