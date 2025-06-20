package com.todocodeacademy.pagos.repository;

import com.todocodeacademy.pagos.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("cart-service")
public interface ICartAPI {

    @GetMapping("/cart/get-cart/{id}")
    public CartDTO getCart(@PathVariable("id") Long id);

}
