package com.todocodeacademy.pedidos.controller;


import com.todocodeacademy.pedidos.dto.CartDTO;
import com.todocodeacademy.pedidos.dto.PaymentDTO;
import com.todocodeacademy.pedidos.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save-payment/{id}")
    public PaymentDTO savePayment(@PathVariable Long id){
        return orderService.savePayment(id);
    }
    @GetMapping("get-payment/{id}")
    public PaymentDTO getPayment(@PathVariable Long id){
        return orderService.getPayment(id);
    }

}
