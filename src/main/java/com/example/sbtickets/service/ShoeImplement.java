package com.example.sbtickets.service;

import com.example.sbtickets.entity.Shoe;

import java.util.List;

public interface ShoeImplement {
    public List<Shoe> getShoe();
    public Shoe getShoeById(int id);
    public void createShoe(Shoe shoe);
    public void updateShoe(Integer id, Shoe shoe);
    public void deleteShoe(int id);
}
