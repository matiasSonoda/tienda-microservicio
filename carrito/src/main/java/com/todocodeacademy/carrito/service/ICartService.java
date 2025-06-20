package com.todocodeacademy.carrito.service;

import com.todocodeacademy.carrito.dto.ProductDTO;
import com.todocodeacademy.carrito.model.Cart;

public interface ICartService {

    public Cart getCart(Long id);

    public Cart createCart();

    public Cart addProductToCart(Long id, ProductDTO product);

    public Cart clearCart(Long id);
}
