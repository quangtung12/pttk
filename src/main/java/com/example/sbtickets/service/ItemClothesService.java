package com.example.sbtickets.service;

import com.example.sbtickets.entity.ItemClothes;
import com.example.sbtickets.repository.ItemClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemClothesService implements ItemClothesImplement{
    @Autowired
    ItemClothesRepository itemClothesRespository;


    @Override
    public ItemClothes getItemClothesId(int id) {
        try{
            ItemClothes itemClothes = itemClothesRespository.findById(id).orElseThrow(() -> new Exception("Not found Clothes"));
            return itemClothes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ItemClothes> getItemClothes() {
        List<ItemClothes> listItemClothes;
        try{
            listItemClothes = itemClothesRespository.findAll();
            return listItemClothes;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void createItemClothes(ItemClothes itemClothes) {
        try{
            itemClothesRespository.save(itemClothes);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateItemClothes(ItemClothes itemClothes) {
        try {
            itemClothesRespository.save(itemClothes);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteItemClothes(int id) {
        try {
            if (itemClothesRespository.existsById(id)) {
                itemClothesRespository.deleteById(id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
