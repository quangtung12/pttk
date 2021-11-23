package com.example.sbtickets.repository;

import com.example.sbtickets.entity.ItemShoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemShoeRepository extends JpaRepository<ItemShoe, Integer> {

}

