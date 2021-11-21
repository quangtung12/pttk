package com.example.sbtickets.service;

import com.example.sbtickets.entity.Shoe;
import com.example.sbtickets.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeService implements ShoeImplement{

    @Autowired
    ShoeRepository shoeRepository;

    @Override
    public List<Shoe> getShoe() {
        List<Shoe> listShoe = shoeRepository.findAll();
        return listShoe;
    }

}
