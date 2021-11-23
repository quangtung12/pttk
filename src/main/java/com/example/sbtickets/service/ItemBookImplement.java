package com.example.sbtickets.service;

import com.example.sbtickets.entity.Book;
import com.example.sbtickets.entity.ItemBook;

import java.util.List;

public interface ItemBookImplement {
    public List<ItemBook> getItemBooks();
    public ItemBook getItemBookById(int id);
    public void createItemBook(ItemBook itemBook);
    public void updateItemBook(ItemBook itemBook);
    public void deleteItemBook(int id);
    public void deleteBook(ItemBook itemBook);
}
