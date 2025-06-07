package com.todocodeacademy.pagos.repository;

import com.todocodeacademy.pagos.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="product-service")
public interface IProductAPI {

    @PutMapping("/update-stock")
    public String updateStock(@RequestBody List<ProductDTO> listProduct);

}
