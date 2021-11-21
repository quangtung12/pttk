package com.example.sbtickets.repository;


import com.example.sbtickets.entity.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoe, Integer> {
}
