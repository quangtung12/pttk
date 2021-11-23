package com.example.sbtickets.service;

import com.example.sbtickets.entity.ItemElectronic;
import com.example.sbtickets.repository.ItemElectronicRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemElectronicService implements ItemElectronicImplement{

    @Autowired
    ItemElectronicRespository itemElectronicRespository;

    @Override
    public List<ItemElectronic> getItemElectronic() {
        return itemElectronicRespository.findAll();
    }

    @Override
    public ItemElectronic getItemElectronicById(int id) {
        return itemElectronicRespository.getById(id);
    }

    @Override
    public void createItemElectronic(ItemElectronic itemElectronic) {
        try {
            itemElectronicRespository.save(itemElectronic);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateItemElectronic(ItemElectronic itemElectronic) {
        try {
            itemElectronicRespository.save(itemElectronic);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteItemElectronic(int id) {
        try {
            if (itemElectronicRespository.existsById(id)) {
                itemElectronicRespository.deleteById(id);
            }
        } catch (Exception ex
        ) {
            ex.printStackTrace();
        }
    }
}
