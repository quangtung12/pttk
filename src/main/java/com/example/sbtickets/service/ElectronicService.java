package com.example.sbtickets.service;

import com.example.sbtickets.entity.Electronic;
import com.example.sbtickets.repository.ElectronicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicService implements ElectronicImplement{
    @Autowired
    ElectronicRepository electronicRepository;
    @Override
    public List<Electronic> getElectronic() {
        List<Electronic> electronicList = electronicRepository.findAll();
        return electronicList;
    }

    @Override
    public Electronic getElectronicById(int id) {
        return electronicRepository.getById(id);
    }

    @Override
    public void createElectronic(Electronic electronic) {
        try {
            electronicRepository.save(electronic);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateElectronic(Electronic electronic) {
        try {
            electronicRepository.save(electronic);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteElectronic(int id) {
        try {
            electronicRepository.deleteById(id);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
