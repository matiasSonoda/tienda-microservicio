package com.todocodeacademy.pagos.service;

import com.todocodeacademy.pagos.dto.PaymentRequestDTO;

public interface IPaymentService {

    public String payOrder(PaymentRequestDTO pay);

}
