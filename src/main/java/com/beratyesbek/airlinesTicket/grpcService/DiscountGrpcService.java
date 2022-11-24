package com.beratyesbek.airlinesTicket.grpcService;

import com.beratyesbek.airlinesTicket.models.BoughtTicket;
import com.beratyesbek.grpc.Discount;
import com.beratyesbek.grpc.DiscountResponse;

public interface DiscountGrpcService {
    DiscountResponse getDiscount(BoughtTicket boughtTicket,String code);
}
