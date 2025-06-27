package com.todocodeacademy.pedidos.service;

import com.todocodeacademy.pedidos.dto.CartDTO;
import com.todocodeacademy.pedidos.dto.PaymentDTO;

public interface IOrderService {

    public CartDTO createCart();

    public CartDTO addProductToCart(Long idProduct);

    public PaymentDTO savePayment(Long idCart);

    public PaymentDTO getPayment(Long id);

}
