package com.example.sbtickets.service;

import com.example.sbtickets.entity.ItemShoe;

import java.util.List;

public interface ItemShoeImplement {
    public List<ItemShoe> getItemShoes();

    public ItemShoe getItemShoeById(int id);

    public void createItemShoe(ItemShoe itemShoe);

    public void updateItemShoe(ItemShoe itemShoe);

    public void deleteItemShoe(int id);
}