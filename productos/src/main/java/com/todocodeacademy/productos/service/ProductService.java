package com.todocodeacademy.productos.service;

import com.todocodeacademy.productos.model.Product;
import com.todocodeacademy.productos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
