package com.example.sbtickets.repository;

import com.example.sbtickets.entity.ItemElectronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemElectronicRespository extends JpaRepository<ItemElectronic, Integer> {
}
