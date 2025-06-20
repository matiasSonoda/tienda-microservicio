package com.todocodeacademy.carrito.service;

import com.todocodeacademy.carrito.dto.ProductDTO;
import com.todocodeacademy.carrito.model.Cart;
import com.todocodeacademy.carrito.model.CartItem;
import com.todocodeacademy.carrito.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements  ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    @Transactional
    @Override
    public Cart addProductToCart(Long id, ProductDTO dto) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        CartItem currentProd = new CartItem();
        currentProd.setIdProduct(dto.getIdProduct());
        currentProd.setName(dto.getName());
        currentProd.setPrice(dto.getPrice());
        currentProd.setCart(cart);
        currentProd.setQuantity(dto.getQuantity());
        cart.getListProducts().add(currentProd);

        Double total = cart.getListProducts().stream()
                .map(CartItem::getPrice)
                .reduce(0.0,(subtotal, price) -> subtotal + price );
        cart.setTotal(total);
        return cartRepository.save(cart);
    }

    public Cart clearCart(Long id){
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.setTotal(0D);
        cart.getListProducts().clear();
        return cart;
    }

}
