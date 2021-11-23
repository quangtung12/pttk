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
        try{
            List<Clothes> listClothes = clothesRespository.findAll();
            return listClothes;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public Clothes getClothesById(int id) {
        try {
            Clothes itemClothes = clothesRespository.findById(id).orElseThrow(() -> new Exception("Not found Clothes"));
            return itemClothes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void createClothes(Clothes clothes) {
        try {
            clothesRespository.save(clothes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateClothes(Clothes clothes) {
        try {
            clothesRespository.save(clothes);

        } catch (Exception ex
        ) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteClothes(int id) {
        try {
            if (clothesRespository.existsById(id)) {
                clothesRespository.deleteById(id);
            }
        } catch (Exception ex
        ) {
            ex.printStackTrace();
        }
    }
}
