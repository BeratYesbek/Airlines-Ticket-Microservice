package com.beratyesbek.airlinesTicket.mailerService;

import java.util.Map;

public interface NotifyService {
    void sendNotify(String message, Map<String, Object> headers);
}
