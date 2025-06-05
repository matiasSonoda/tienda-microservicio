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

    @GetMapping("/get-cart")
    public Cart getCart(){
        return cartService.getCart();
    }

    @PostMapping("/create-cart")
    public Cart createCart(){
        return cartService.createCart();
    }

    @PostMapping("/add-product-to-cart")
    public Cart addProductToCart(@RequestBody ProductDTO product){
        return cartService.addProductToCart(product);
    }

}
