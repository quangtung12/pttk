package com.example.sbtickets.service;

import com.example.sbtickets.entity.Order;
import com.example.sbtickets.repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderImplement{

    @Autowired
    OrderRespository orderRespository;

    @Override
    public void createOrder(Order order) {
        try {
            orderRespository.save(order);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRespository.getById(id);
    }
}
