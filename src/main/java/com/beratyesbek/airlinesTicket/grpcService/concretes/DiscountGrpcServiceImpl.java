package com.beratyesbek.airlinesTicket.grpcService.concretes;


import com.beratyesbek.airlinesTicket.grpcService.abstracts.DiscountGrpcService;
import com.beratyesbek.airlinesTicket.models.BoughtTicket;
import com.beratyesbek.grpc.DiscountRequest;
import com.beratyesbek.grpc.DiscountResponse;
import com.beratyesbek.grpc.DiscountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class DiscountGrpcServiceImpl implements DiscountGrpcService {

    @GrpcClient("Discount")
    private DiscountServiceGrpc.DiscountServiceBlockingStub discountServiceStub;
    private ManagedChannel channel;

    public DiscountGrpcServiceImpl() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }

    @Override
    public DiscountResponse getDiscount(BoughtTicket boughtTicket, String code) {
        discountServiceStub = DiscountServiceGrpc.newBlockingStub(channel);
        DiscountResponse discountResponse = discountServiceStub.getDiscount(
                DiscountRequest.newBuilder()
                        .setCode(code)
                        .setUserPhone(boughtTicket.getPhoneNumber())
                        .setUserEmail(boughtTicket.getUserEmail())
                        .setPrice(boughtTicket.getPrice().floatValue())
                        .build()
        );
        return discountResponse;
    }
}
