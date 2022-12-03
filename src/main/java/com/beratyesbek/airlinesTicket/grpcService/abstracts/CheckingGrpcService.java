package com.beratyesbek.airlinesTicket.grpcService.abstracts;

import com.beratyesbek.airlinesTicket.models.BoughtTicket;
import com.beratyesbek.grpc.BoughtTicketRequest;

public interface CheckingGrpcService {
    void saveBoughtTicket(BoughtTicket boughtTicket);
}
