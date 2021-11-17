package com.example.sbtickets.service;

import com.example.sbtickets.entity.Payment;
import com.example.sbtickets.repository.PaymentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements PaymentImplement {
    @Autowired
    PaymentReponsitory paymentReponsitory;

    @Override
    public List<Payment> getPayment() {
        List<Payment> listPayment = paymentReponsitory.findAll();
        return listPayment ;
    }
}
