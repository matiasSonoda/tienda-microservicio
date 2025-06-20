package com.todocodeacademy.pagos.controller;

import com.todocodeacademy.pagos.dto.CartDTO;
import com.todocodeacademy.pagos.dto.PaymentDTO;
import com.todocodeacademy.pagos.model.Payment;
import com.todocodeacademy.pagos.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;


    @GetMapping("/{id}")
    public PaymentDTO savePayment(@PathVariable Long id){
        return paymentService.getPayment(id);
    }

    @PostMapping("")
    public Payment savePayment(@RequestBody CartDTO dto){
        return paymentService.savePayment(dto);
    }

}
