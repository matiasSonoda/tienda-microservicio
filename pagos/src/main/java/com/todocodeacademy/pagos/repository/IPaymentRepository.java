package com.todocodeacademy.pagos.repository;

import com.todocodeacademy.pagos.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
