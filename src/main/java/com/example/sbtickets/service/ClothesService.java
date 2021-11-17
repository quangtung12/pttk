package com.example.sbtickets.service;

import com.example.sbtickets.entity.Clothes;
import com.example.sbtickets.repository.ClothesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService implements ClothesImplement{

    @Autowired
    ClothesRespository clothesRespository;

    @Override
    public List<Clothes> getClothes() {
        List<Clothes> listClothes = clothesRespository.findAll();
        return listClothes;
    }
}
