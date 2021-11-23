package com.example.sbtickets.service;

import com.example.sbtickets.entity.Shoe;
import com.example.sbtickets.entity.ItemShoe;
import com.example.sbtickets.repository.ItemShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemShoeService implements ItemShoeImplement {
    @Autowired
    ItemShoeRepository itemShoeRepository;

    @Override
    public List<ItemShoe> getItemShoes() {
        List<ItemShoe> listItemShoes;
        try {
            listItemShoes = itemShoeRepository.findAll();
            return listItemShoes;
        } catch (
                Exception ex
        ) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemShoe getItemShoeById(int id) {
        try {
            ItemShoe itemShoe = itemShoeRepository.findById(id).orElseThrow(() -> new Exception("Not found Shoe"));
            return itemShoe;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void createItemShoe(ItemShoe itemShoe) {
        try {
            itemShoeRepository.save(itemShoe);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateItemShoe(ItemShoe itemShoe) {
        try {
            itemShoeRepository.save(itemShoe);

        } catch (Exception ex
        ) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteItemShoe(int id) {
        try {
            if (itemShoeRepository.existsById(id)) {
                itemShoeRepository.deleteById(id);
            }
        } catch (Exception ex
        ) {
            ex.printStackTrace();
        }

    }

}
