package com.example.sbtickets.service;

import com.example.sbtickets.entity.Shoe;
import com.example.sbtickets.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoeService implements ShoeImplement{

    @Autowired
    ShoeRepository shoeRepository;

    @Override
    public List<Shoe> getShoe() {
        List<Shoe> listShoe = shoeRepository.findAll();
        return listShoe;
    }

    @Override
    public Shoe getShoeById(int id) {
        try {
            Shoe shoe = shoeRepository.findById(id).orElseThrow(() -> new Exception("Not found Shoe"));
            return shoe;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createShoe(Shoe shoe) {
        try {
            shoeRepository.save(shoe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateShoe(Integer id, Shoe shoe) {
        try {
            Optional<Shoe> dbShoe = shoeRepository.findById(id);
            Shoe foundShoe = dbShoe.get();
            foundShoe.setName(shoe.getName());
            foundShoe.setManufacure(shoe.getManufacure());
            foundShoe.setSize(shoe.getSize());
            foundShoe.setMaterial(shoe.getMaterial());
            foundShoe.setColor(shoe.getColor());
            foundShoe.setStyle(shoe.getStyle());
            foundShoe.setImage(shoe.getImage());
            foundShoe.setShoeBrand(shoe.getShoeBrand());
            shoeRepository.save(foundShoe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteShoe(int id) {
        try {
            if(shoeRepository.existsById(id)){
                shoeRepository.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
