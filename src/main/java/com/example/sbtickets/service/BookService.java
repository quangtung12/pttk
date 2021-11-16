package com.example.sbtickets.service;

import com.example.sbtickets.entity.Book;
import com.example.sbtickets.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookImplement{

    @Autowired
    BookRespository bookRespository;

    @Override
    public List<Book> getBook() {
        List<Book> listBook = bookRespository.findAll();
        return listBook;
    }
}
