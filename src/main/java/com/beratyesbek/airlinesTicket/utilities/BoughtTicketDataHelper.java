package com.beratyesbek.airlinesTicket.utilities;

import com.beratyesbek.airlinesTicket.models.BoughtTicket;

import java.util.HashMap;
import java.util.Map;

/**
 * prepare data helper for GRPC and RabbitMQ
 */
public class BoughtTicketDataHelper {

    public static Map<String, Object> prepareHeadersDataForMailerService(BoughtTicket boughtTicket) {
        Map<String,Object> headers = new HashMap<>();
        headers.put("flightDate",boughtTicket.getTicket().getFlightDate());
        headers.put("phoneNumber",boughtTicket.getPhoneNumber());
        headers.put("userEmail",boughtTicket.getUserEmail());
        headers.put("companyName",boughtTicket.getTicket().getCompanyName());
        headers.put("from",boughtTicket.getTicket().getFrom().getName());
        headers.put("to",boughtTicket.getTicket().getTo().getName());
        return headers;
    }
}
