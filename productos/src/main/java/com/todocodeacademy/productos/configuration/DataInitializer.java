package com.todocodeacademy.productos.configuration;

import com.todocodeacademy.productos.model.Product;
import com.todocodeacademy.productos.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(ProductRepository productRepository){
        return args -> {
            Product p1 = new Product();
            p1.setName("Teclado Mecánico RGB");
            p1.setPrice(12000.0);
            p1.setStock(25);
            p1.setDescription("Teclado mecánico con retroiluminación RGB y switches blue");

            Product p2 = new Product();
            p2.setName("Monitor 27'' Full HD");
            p2.setPrice(95000.0);
            p2.setStock(15);
            p2.setDescription("Monitor LED 27 pulgadas, resolución Full HD, con HDMI y DisplayPort");

            Product p3 = new Product();
            p3.setName("Mouse Gamer Inalámbrico");
            p3.setPrice(8500.0);
            p3.setStock(40);
            p3.setDescription("Mouse ergonómico con 6 botones programables y sensor de alta precisión");

            Product p4 = new Product();
            p4.setName("Auriculares Bluetooth");
            p4.setPrice(13000.0);
            p4.setStock(30);
            p4.setDescription("Auriculares inalámbricos con cancelación de ruido y micrófono integrado");

            Product p5 = new Product();
            p5.setName("Silla Ergonómica Gamer");
            p5.setPrice(105000.0);
            p5.setStock(10);
            p5.setDescription("Silla ergonómica con soporte lumbar y reclinación 180°");

            productRepository.saveAll(List.of(p1, p2, p3, p4, p5));

        };
    }

}
