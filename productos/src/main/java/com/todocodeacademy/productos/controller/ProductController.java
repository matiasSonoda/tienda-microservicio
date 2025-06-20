package com.todocodeacademy.productos.controller;

import com.todocodeacademy.productos.model.Product;
import com.todocodeacademy.productos.model.dto.ProductDTO;
import com.todocodeacademy.productos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @PutMapping("/update-stock")
    public String updateStock(@RequestBody List<ProductDTO> listProduct){
        return productService.updateStock(listProduct);
    }

}
