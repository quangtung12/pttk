package com.example.sbtickets.service;


import com.example.sbtickets.entity.Electronic;

import java.util.List;

public interface ElectronicImplement {
    public List<Electronic> getElectronic();
    public Electronic getDetailElectronic(Integer id);
    public Electronic createElectronic(Electronic electronic);
    public void updateElectronic(Integer id, Electronic electronic);
    public void removeElectronic(Integer id);
}
