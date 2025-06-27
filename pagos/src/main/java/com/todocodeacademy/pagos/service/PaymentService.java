package com.todocodeacademy.pagos.service;

import com.todocodeacademy.pagos.dto.CartDTO;
import com.todocodeacademy.pagos.dto.PaymentDTO;
import com.todocodeacademy.pagos.model.Payment;
import com.todocodeacademy.pagos.repository.ICartAPI;
import com.todocodeacademy.pagos.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService implements IPaymentService{

    @Autowired
    private ICartAPI cartAPI;

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public PaymentDTO savePayment(CartDTO dto) {
        Payment payment = new Payment();
        payment.setDate(LocalDateTime.now());
        payment.setIdCart(dto.getIdCart());
        Payment auxiliar = paymentRepository.save(payment);
        PaymentDTO response = new PaymentDTO();
        response.setIdPayment(auxiliar.getIdPayment());
        response.setDate(auxiliar.getDate());
        response.setCart(dto);
        return response;
    }

    @Override
    public PaymentDTO getPayment(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        PaymentDTO response = new PaymentDTO();
        response.setIdPayment(payment.getIdPayment());
        response.setDate(payment.getDate());
        CartDTO dto = cartAPI.getCart(payment.getIdCart());
        response.setCart(dto);
        return response;
    }
}
