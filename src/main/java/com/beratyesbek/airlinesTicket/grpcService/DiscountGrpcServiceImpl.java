package com.beratyesbek.airlinesTicket.grpcService;


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
    DiscountServiceGrpc.DiscountServiceBlockingStub discountServiceStub;
    ManagedChannel channel;

    public DiscountGrpcServiceImpl() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }

    @Override
    public DiscountResponse getDiscount(BoughtTicket boughtTicket, String code) {
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
