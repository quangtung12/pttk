package com.example.sbtickets.service;

import com.example.sbtickets.authentication.entity.Customer;
import com.example.sbtickets.authentication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerImplement{

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer findCustomer(int id) {
        return customerRepository.getById(id);
    }
}
