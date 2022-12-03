package com.beratyesbek.airlinesTicket.grpcService.concretes;

import com.beratyesbek.airlinesTicket.grpcService.abstracts.CheckingGrpcService;
import com.beratyesbek.airlinesTicket.models.BoughtTicket;
import com.beratyesbek.grpc.BoughtTicketGRPCServiceGrpc;
import com.beratyesbek.grpc.BoughtTicketRequest;
import com.beratyesbek.grpc.CheckingServiceGrpc;
import com.beratyesbek.grpc.DiscountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class CheckingGrpcServiceImpl implements CheckingGrpcService {

    @GrpcClient("BoughtTicket")
    private CheckingServiceGrpc.CheckingServiceBlockingStub grpcService;
    private ManagedChannel channel;

    public CheckingGrpcServiceImpl() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();
    }
    @Override
    public void saveBoughtTicket(BoughtTicket boughtTicket) {
        grpcService = CheckingServiceGrpc.newBlockingStub(channel);
        grpcService.saveBoughtTicket(
                BoughtTicketRequest.newBuilder()
                        .setCheckingCode(boughtTicket.getCheckingCode())
                        .setFullName(boughtTicket.getFullName())
                        .setIdentityNumber(boughtTicket.getIdentityNumber())
                        .setSeatGroup(boughtTicket.getSeatGroup())
                        .setSeatNumber(boughtTicket.getSeatNumber())
                        .setExternalId(boughtTicket.getBoughtTicketId()).build()
        );

    }
}
