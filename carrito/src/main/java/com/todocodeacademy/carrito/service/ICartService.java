package com.todocodeacademy.carrito.service;

import com.todocodeacademy.carrito.dto.ProductDTO;
import com.todocodeacademy.carrito.model.Cart;

public interface ICartService {

    public Cart createCart();

    public Cart addProductToCart(ProductDTO product);

}
