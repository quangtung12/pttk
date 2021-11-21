package com.example.sbtickets.authentication.service;

import com.example.sbtickets.authentication.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerImplement implements CustomerDAO {

    @Override
    public List<Customer> getCustomers() {
        return null;
    }
}
