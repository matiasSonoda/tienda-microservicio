package com.todocodeacademy.carrito.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarrito;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<CartItem> listProducts = new ArrayList<>();

    private Double total;
}
