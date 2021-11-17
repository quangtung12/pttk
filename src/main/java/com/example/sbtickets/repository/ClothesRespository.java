package com.example.sbtickets.repository;

import com.example.sbtickets.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRespository extends JpaRepository<Clothes, Integer> {
}
