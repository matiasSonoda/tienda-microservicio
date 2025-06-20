package com.todocodeacademy.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrentProductDTO {

        private Long idProduct;
        private String name;
        private Double price;
        private Integer stock;
        private String description;

}
