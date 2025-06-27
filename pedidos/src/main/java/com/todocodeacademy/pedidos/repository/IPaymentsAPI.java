package com.todocodeacademy.pedidos.repository;

import com.todocodeacademy.pedidos.dto.CartDTO;
import com.todocodeacademy.pedidos.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("payments-service")
public interface IPaymentsAPI {

    @GetMapping("/payment/{id}")
    public PaymentDTO getPayment(@PathVariable("{id}") Long id);

    @PostMapping("/payment")
    public PaymentDTO savePayment(@RequestBody CartDTO cartDTO);

}
