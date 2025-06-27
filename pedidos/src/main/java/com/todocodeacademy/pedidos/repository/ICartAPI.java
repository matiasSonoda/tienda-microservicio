package com.todocodeacademy.pedidos.repository;

import com.todocodeacademy.pedidos.dto.CartDTO;
import com.todocodeacademy.pedidos.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cart-service")
public interface ICartAPI {

    @GetMapping("/get-cart/{id}")
    public CartDTO getCart(@PathVariable(name = "id") Long id);

    @PostMapping("/cart/create-cart")
    public CartDTO createCart();

    @PostMapping("/cart/add-product-to-cart")
    public CartDTO addProductToCart(@RequestBody ProductDTO product);

    @PostMapping("/cart/clear-cart")
    public void clearCart();
}
