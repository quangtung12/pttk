package com.example.sbtickets.repository;
import com.example.sbtickets.entity.Electronic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ElectronicRespository extends JpaRepository<Electronic, Integer> {
}
