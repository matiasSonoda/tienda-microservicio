package com.todocodeacademy.productos.service;

import com.todocodeacademy.productos.model.Product;
import com.todocodeacademy.productos.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    public Product getProduct(Long id);

    public String updateStock(List<ProductDTO> listProduct);
}
