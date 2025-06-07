package com.todocodeacademy.pagos.service;

import com.todocodeacademy.pagos.dto.CartDTO;
import com.todocodeacademy.pagos.dto.PaymentRequestDTO;
import com.todocodeacademy.pagos.dto.ProductDTO;
import com.todocodeacademy.pagos.repository.ICartAPI;
import com.todocodeacademy.pagos.repository.IProductAPI;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService implements IPaymentService{

    @Autowired
    private ICartAPI cartAPI;

    @Autowired
    private IProductAPI productAPI;

    @Override
    public String payOrder(PaymentRequestDTO pay) {

        CartDTO cartDTO = cartAPI.getCart();

        if (cartDTO.getListProduct().isEmpty()){
            return "Carrito vacio";
        }

        Double total = cartDTO.getListProduct()
                .stream()
                .map(ProductDTO::getPrice)
                .reduce(0.0, (subtotal, price) -> subtotal + price);

        if(total > pay.getPay()){
            return "Dinero insuficiente";
        }

        String response = productAPI.updateStock(cartDTO.getListProduct());

        System.out.println(response);

        Double change = total - pay.getPay();
        return "El vuelto es: " + change;

    }
}
