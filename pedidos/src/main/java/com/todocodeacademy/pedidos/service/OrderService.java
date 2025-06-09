package com.todocodeacademy.pedidos.service;


import com.todocodeacademy.pedidos.dto.CartDTO;
import com.todocodeacademy.pedidos.dto.ProductDTO;
import com.todocodeacademy.pedidos.repository.ICartAPI;
import com.todocodeacademy.pedidos.repository.IProductAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements  IOrderService{

    @Autowired
    private ICartAPI cartAPI;

    @Autowired
    private IProductAPI productAPI;

    @Override
    public CartDTO createCart() {
        return cartAPI.createCart();
    }

    @Override
    public CartDTO addProductToCart(Long idProduct) {
        ProductDTO product = productAPI.getProduct(idProduct);
        return cartAPI.addProductToCart(product);
    }

    @Override
    public String payProducts(Double pay) {
        return "";
    }
}
