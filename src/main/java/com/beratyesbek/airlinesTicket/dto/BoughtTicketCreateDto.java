package com.beratyesbek.airlinesTicket.dto;

import com.beratyesbek.airlinesTicket.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BoughtTicketCreateDto {
    private Ticket ticket;

    private String userEmail;

    private String identityNumber;
    private String fullName;
    private BigDecimal price;

    private String phoneNumber;

    private String cardNumber;
    private String code;

    private int cardYear;

    private int cardMonth;

    private int cvv;

    private String cardName;

}
