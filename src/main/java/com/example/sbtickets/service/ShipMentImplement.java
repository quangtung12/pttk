package com.example.sbtickets.service;

import com.example.sbtickets.entity.Shipment;

public interface ShipMentImplement {
    public Shipment findShipMent(int id);

    public void updateShipMent(Shipment shipment);
}
