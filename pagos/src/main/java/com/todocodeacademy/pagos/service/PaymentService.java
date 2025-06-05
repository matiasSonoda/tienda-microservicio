package com.todocodeacademy.pagos.service;

import com.todocodeacademy.pagos.dto.CartDTO;
import com.todocodeacademy.pagos.repository.ICartAPI;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService implements IPaymentService{

    @Autowired
    private ICartAPI cartAPI;

    @Override
    public String payOrder(CartDTO cartDTO) {



        return "";

    }
}
