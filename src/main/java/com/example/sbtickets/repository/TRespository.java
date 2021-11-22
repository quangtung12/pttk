package com.example.sbtickets.repository;

import com.example.sbtickets.entity.Cart;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TRespository extends JpaRepository<Cart, Integer> {
}
