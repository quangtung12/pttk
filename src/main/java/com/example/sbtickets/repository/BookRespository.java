package com.example.sbtickets.repository;

import com.example.sbtickets.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Book, Integer> {
}
