package com.todocodeacademy.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Long idPayment;
    private LocalDateTime date;
    private CartDTO idCart;
}
