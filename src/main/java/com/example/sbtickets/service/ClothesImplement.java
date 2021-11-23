package com.example.sbtickets.service;

import com.example.sbtickets.entity.Clothes;
import com.example.sbtickets.repository.ClothesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ClothesImplement implements ClothesDAO{

    @Autowired
    ClothesRespository clothesRespository;

    @Override
    public List<Clothes> getClothes() {
        List<Clothes> listClothes = clothesRespository.findAll();
        return listClothes;
    }
    @Override
    public Clothes createClothes(Clothes clothes){
        Clothes newClothes = clothesRespository.save(clothes);
        return newClothes;
    }
    @Override
    public Clothes getClothesById(Integer id){
        Optional<Clothes> dbClothes = clothesRespository.findById(id);
        Clothes foundClothes = dbClothes.get();
        return foundClothes;
    }

    @Override
    public void updateClothes(Clothes clothes){
        clothesRespository.save(clothes);
        return;
    }

    @Override
    public void deleteClothes(Integer id){
        clothesRespository.deleteById(id);
        return;
    }

    @Override
    public void deleteClothesS(List<Integer> ids){
        clothesRespository.findAllById(ids);
        return;
    }
/*
    @Override
    public Clothes findClothes(String name){
        List<Clothes> listClothes = clothesRespository.findAll();
        Clothes foundClothes = null;
        name.toLowerCase();
        for (int i = 0; i < listClothes.size(); i++){
            Clothes clothes = listClothes.get(i);
            if (clothes.equals(name)){
                foundClothes = clothes;
            }
        }
        return foundClothes;
    }*/
}
