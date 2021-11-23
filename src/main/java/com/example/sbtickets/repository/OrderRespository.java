package com.example.sbtickets.repository;

import com.example.sbtickets.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface OrderRespository extends JpaRepository<Order, Integer> {

}
