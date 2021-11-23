package com.example.sbtickets.repository;

import com.example.sbtickets.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipMentRespository extends JpaRepository<Shipment, Integer> {
}
