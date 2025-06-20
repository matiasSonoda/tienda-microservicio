package com.todocodeacademy.carrito.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;

    private Long idProduct;
    private String name;
    private Double price;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id")
    @JsonBackReference
    private Cart cart;

}
