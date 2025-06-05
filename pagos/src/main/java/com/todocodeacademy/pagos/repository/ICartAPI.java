package com.todocodeacademy.pagos.repository;

import com.todocodeacademy.pagos.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="cart-service")
public interface ICartAPI {

    @GetMapping("/cart/get-cart")
    public CartDTO getCart();

}
