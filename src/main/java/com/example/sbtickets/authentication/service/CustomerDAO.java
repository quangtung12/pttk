package com.example.sbtickets.authentication.service;

import com.example.sbtickets.authentication.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
}
