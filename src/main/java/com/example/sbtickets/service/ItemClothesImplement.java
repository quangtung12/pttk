package com.example.sbtickets.service;

import com.example.sbtickets.entity.ItemClothes;

import java.util.List;

public interface ItemClothesImplement {
    public List<ItemClothes> getItemClothes();
    public void createItemClothes(ItemClothes itemClothes);
    public void updateItemClothes(ItemClothes itemClothes);
    public void deleteItemClothes(int id);
    public ItemClothes getItemClothesId(int id);
}
