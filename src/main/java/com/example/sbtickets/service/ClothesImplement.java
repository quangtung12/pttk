package com.example.sbtickets.service;

import com.example.sbtickets.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothesImplement {
    public List<Clothes> getClothes();
}
