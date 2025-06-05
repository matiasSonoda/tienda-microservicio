package com.todocodeacademy.pagos.service;

import com.todocodeacademy.pagos.dto.CartDTO;
import org.springframework.web.bind.annotation.PostMapping;

public interface IPaymentService {

    public String payOrder(CartDTO cartDTO);

}
