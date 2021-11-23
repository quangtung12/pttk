package com.example.sbtickets.service;

import com.example.sbtickets.entity.ItemBook;
import com.example.sbtickets.entity.ItemElectronic;

import java.util.List;

public interface ItemElectronicImplement {
    public List<ItemElectronic> getItemElectronic();
    public ItemElectronic getItemElectronicById(int id);
    public void createItemElectronic(ItemElectronic itemElectronic);
    public void updateItemElectronic(ItemElectronic itemElectronic);
    public void deleteItemElectronic(int id);
}
