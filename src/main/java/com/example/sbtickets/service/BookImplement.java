package com.example.sbtickets.service;

import com.example.sbtickets.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookImplement {
    public List<Book> getBooks();
    public Book getBookById(int id);
    public void createBook(Book book);
    public void updateBook( Book book);
    public void deleteBook(int id);
}
