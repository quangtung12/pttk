package com.example.sbtickets.service;

import com.example.sbtickets.entity.Book;
import com.example.sbtickets.entity.Electronic;

import java.util.List;

public interface ElectronicImplement {
    public List<Electronic> getElectronic();
    public Electronic getElectronicById(int id);
    public void createElectronic(Electronic electronic);
    public void updateElectronic(Electronic electronic);
    public void deleteElectronic(int id);
}
