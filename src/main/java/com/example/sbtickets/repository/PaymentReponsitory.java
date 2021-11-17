package com.example.sbtickets.repository;

import com.example.sbtickets.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentReponsitory extends JpaRepository<Payment, Integer> {
}