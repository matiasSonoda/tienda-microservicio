package com.todocodeacademy.pagos.controller;

import com.todocodeacademy.pagos.dto.PaymentRequestDTO;
import com.todocodeacademy.pagos.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @PostMapping("")
    public String payOrder(@RequestBody PaymentRequestDTO paymentRequestDTO){
        return paymentService.payOrder(paymentRequestDTO);
    }

}
