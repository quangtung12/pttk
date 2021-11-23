package com.example.sbtickets.service;

import com.example.sbtickets.entity.Order;

public interface OrderImplement {
    public void createOrder(Order order);
    public Order getOrderById(Integer id);
}
