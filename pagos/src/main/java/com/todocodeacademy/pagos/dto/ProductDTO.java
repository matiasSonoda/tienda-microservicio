package com.todocodeacademy.pagos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long idProduct;
    private String name;
    private Double price;

}
