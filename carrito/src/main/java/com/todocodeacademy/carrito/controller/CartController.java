package com.todocodeacademy.carrito.controller;

import com.todocodeacademy.carrito.dto.ProductDTO;
import com.todocodeacademy.carrito.model.Cart;
import com.todocodeacademy.carrito.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @PostMapping("/create-cart")
    public Cart createCart(){
        return cartService.createCart();
    }

    @PostMapping("/add-product-to-cart")
    public Cart addProductToCart(@RequestBody ProductDTO product){
        return cartService.addProductToCart(product);
    }

}
