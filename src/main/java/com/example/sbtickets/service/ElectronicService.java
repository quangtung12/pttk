package com.example.sbtickets.service;

import com.example.sbtickets.bean.ElectronicBean;
import com.example.sbtickets.entity.Electronic;
import com.example.sbtickets.repository.ElectronicRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ElectronicService implements ElectronicImplement {
    @Autowired
    ElectronicRespository electronicRepository;
    @Override
    public List<Electronic> getElectronic() {
        List<Electronic> listElectronic = electronicRepository.findAll();
        return  listElectronic;
    }

    @Override
    public Electronic getDetailElectronic(Integer id) {
        Optional<Electronic> dbElectronic = electronicRepository.findById(id);
        Electronic foundElectronic= dbElectronic.get();
        return foundElectronic;
    }


    @Override
    public Electronic createElectronic(Electronic electronic) {
        Electronic newElectronic = electronicRepository.save(electronic);
        return newElectronic;
    }

    @Override
    public void updateElectronic(Integer id, Electronic electronic) {
        Optional<Electronic> dbElectronic = electronicRepository.findById(id);
        Electronic foundElectronic = dbElectronic.get();
        foundElectronic.setItemElectronicID(electronic.getItemElectronicID());
        foundElectronic.setName(electronic.getName());
        foundElectronic.setProductionDay(electronic.getProductionDay());
        foundElectronic.setProducer(electronic.getProducer());
        foundElectronic.setRam(electronic.getRam());
        foundElectronic.setChip(electronic.getChip());
        foundElectronic.setScreenSize(electronic.getScreenSize());
        foundElectronic.setPin(electronic.getPin());
        foundElectronic.setStorage(electronic.getStorage());
        foundElectronic.setHhd(electronic.getHhd());
        foundElectronic.setSsd(electronic.getSsd());
        foundElectronic.setWattage(electronic.getWattage());
        foundElectronic.setGraphicsCard(electronic.getGraphicsCard());
        foundElectronic.setDiscriminator(electronic.getDiscriminator());
        electronicRepository.save(foundElectronic);
        return;
    }

    @Override
    public void removeElectronic(Integer id) {
        electronicRepository.deleteById(id);
        return;
    }
}
