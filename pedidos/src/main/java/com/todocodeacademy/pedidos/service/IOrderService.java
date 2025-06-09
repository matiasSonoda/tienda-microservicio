package com.todocodeacademy.pedidos.service;

import com.todocodeacademy.pedidos.dto.CartDTO;
import com.todocodeacademy.pedidos.dto.ProductDTO;

public interface IOrderService {

    public CartDTO createCart();

    public CartDTO addProductToCart(Long idProduct);

    public String payProducts(Double pay);

}
