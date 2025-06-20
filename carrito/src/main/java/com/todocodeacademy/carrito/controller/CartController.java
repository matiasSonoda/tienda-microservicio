package com.todocodeacademy.carrito.controller;

import com.todocodeacademy.carrito.dto.ProductDTO;
import com.todocodeacademy.carrito.model.Cart;
import com.todocodeacademy.carrito.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @GetMapping("/get-cart/{id}")
    public Cart getCart(@PathVariable Long id){
        return cartService.getCart(id);
    }

    @PostMapping("/create-cart")
    public Cart createCart(){
        return cartService.createCart();
    }

    @PostMapping("/add-product-to-cart/{id}")
    public Cart addProductToCart(
            @PathVariable Long id,
            @RequestBody ProductDTO product){
        return cartService.addProductToCart(id,product);
    }

    @PostMapping("/clear-cart/{id}")
    public Cart clearCart(@PathVariable Long id){
        return cartService.clearCart(id);
    }

}
