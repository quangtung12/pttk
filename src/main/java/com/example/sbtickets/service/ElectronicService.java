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
}
