package com.todocodeacademy.pedidos.repository;

import com.todocodeacademy.pedidos.dto.CurrentProductDTO;
import com.todocodeacademy.pedidos.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("product-service")
public interface IProductAPI {

    @GetMapping("/product/{id}")
    public CurrentProductDTO getProduct(@PathVariable(name = "id") Long id);

    @PutMapping("/product/update-stock")
    public String updateStock(@RequestBody List<ProductDTO> listProduct);

}
