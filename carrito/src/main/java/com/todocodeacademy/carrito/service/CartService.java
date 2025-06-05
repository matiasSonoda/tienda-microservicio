package com.todocodeacademy.carrito.service;

import com.todocodeacademy.carrito.dto.ProductDTO;
import com.todocodeacademy.carrito.model.Cart;
import com.todocodeacademy.carrito.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements  ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCart() {
        return cartRepository.findById(1L).orElseThrow();
    }

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    @Override
    public Cart addProductToCart(ProductDTO product) {
        Cart cart = cartRepository.findById(1L).orElseThrow();
        product.setCart(cart);
        cart.getListProducts().add(product);
        return cartRepository.save(cart);
    }
}
