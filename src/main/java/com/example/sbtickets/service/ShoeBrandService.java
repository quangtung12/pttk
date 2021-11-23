package com.example.sbtickets.service;

import com.example.sbtickets.entity.ShoeBrand;
import com.example.sbtickets.repository.ShoeBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ShoeBrandService implements ShoeBrandImplement{
    @Autowired
    ShoeBrandRepository shoeBrandRepository;

    @Override
    public ShoeBrand getShoeBrandById(Integer id) {
        try {
            ShoeBrand shoeBrand = shoeBrandRepository.findById(id).orElseThrow(() ->new Exception("Not found shoeBrand"));
            return shoeBrand;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
