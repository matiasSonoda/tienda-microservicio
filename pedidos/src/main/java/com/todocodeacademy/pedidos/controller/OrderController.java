package com.todocodeacademy.pedidos.controller;


import com.todocodeacademy.pedidos.dto.CartDTO;
import com.todocodeacademy.pedidos.dto.ProductDTO;
import com.todocodeacademy.pedidos.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/create-cart")
    public CartDTO createCart(){
        return orderService.createCart();
    }

    @PostMapping("/add-producto-to-cart/{idProduct}")
    public CartDTO addProductToCart(@PathVariable Long idProduct){
        return orderService.addProductToCart(idProduct);
    }

    @PostMapping("/pay-order")
    public Boolean payOrder(Double pay){
        return orderService.payProducts(pay);
    }

}
