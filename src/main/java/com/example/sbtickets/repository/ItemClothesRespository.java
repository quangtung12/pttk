package com.example.sbtickets.repository;

import com.example.sbtickets.entity.ItemClothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemClothesRespository {
    public interface ItemClothesRepository extends JpaRepository<ItemClothes, Integer>{
    }
}
