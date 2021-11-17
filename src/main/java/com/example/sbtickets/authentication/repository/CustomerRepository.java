package com.example.sbtickets.authentication.repository;

import com.example.sbtickets.authentication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
