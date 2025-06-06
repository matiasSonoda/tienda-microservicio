package com.todocodeacademy.productos.service;

import com.todocodeacademy.productos.model.Product;
import com.todocodeacademy.productos.model.dto.ProductDTO;
import com.todocodeacademy.productos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public String updateStock(List<ProductDTO> listProduct) {
        listProduct.stream().forEach(productDTO -> {
            Product product = productRepository.findById(productDTO.getIdProduct()).orElseThrow();
            product.setStock(product.getStock() - productDTO.getQuantity());
            productRepository.save(product);
        });
        return "Stock actualizado";
    }
}
