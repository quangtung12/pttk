package com.example.sbtickets.service;

import com.example.sbtickets.entity.Book;
import com.example.sbtickets.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookImplement {

    @Autowired
    BookRespository bookRespository;

    @Override
    public List<Book> getBooks() {
        List<Book> listBook = new ArrayList<>();
        try {
            listBook = bookRespository.findAll();
            return listBook;
        } catch (
                Exception ex
        ) {
            ex.printStackTrace();
        }
        return listBook;
    }

    @Override
    public Book getBookById(int id) {
        try {
            Book itemBook = bookRespository.findById(id).orElseThrow(() -> new Exception("Not found Book"));
            return itemBook;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void createBook(Book book) {
        try {
            bookRespository.save(book);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void updateBook( Book book) {
        try {
                bookRespository.save(book);

        } catch (Exception ex
        ) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteBook(int id) {
        try {
            if (bookRespository.existsById(id)) {
                bookRespository.deleteById(id);
            }
        } catch (Exception ex
        ) {
            ex.printStackTrace();
        }

    }
}
