package com.todocodeacademy.pedidos.repository;

import com.todocodeacademy.pedidos.dto.PaymentRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("payments-service")
public interface IPaymentsAPI {

    @PostMapping("/payment/")
    public Boolean payOrder(@RequestBody PaymentRequestDTO paymentRequestDTO);

}
