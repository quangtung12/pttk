package com.example.sbtickets.repository;

import com.example.sbtickets.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRespository extends JpaRepository<Book, Integer> {

}
