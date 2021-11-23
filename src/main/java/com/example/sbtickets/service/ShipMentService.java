package com.example.sbtickets.service;

import com.example.sbtickets.entity.Shipment;
import com.example.sbtickets.repository.ShipMentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipMentService implements ShipMentImplement{

    @Autowired
    ShipMentRespository shipMentRespository;
    @Override
    public Shipment findShipMent(int id) {
        try {
            return shipMentRespository.findById(id).get();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  null;
    }

    @Override
    public void updateShipMent(Shipment shipment) {
        try {
            shipMentRespository.save(shipment);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
