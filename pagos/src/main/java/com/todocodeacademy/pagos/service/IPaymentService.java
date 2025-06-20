package com.todocodeacademy.pagos.service;

import com.todocodeacademy.pagos.dto.CartDTO;
import com.todocodeacademy.pagos.dto.PaymentDTO;
import com.todocodeacademy.pagos.model.Payment;

public interface IPaymentService {

    public Payment savePayment(CartDTO dto);

    public PaymentDTO getPayment(Long id);

}
