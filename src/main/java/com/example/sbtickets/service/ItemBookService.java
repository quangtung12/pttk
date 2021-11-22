package com.example.sbtickets.service;

import com.example.sbtickets.entity.Book;
import com.example.sbtickets.entity.ItemBook;
import com.example.sbtickets.repository.ItemBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBookService implements ItemBookImplement {
    @Autowired
    ItemBookRepository itemBookRepository;

    @Override
    public List<ItemBook> getItemBooks() {
        List<ItemBook> listItemBooks;
        try {
            listItemBooks = itemBookRepository.findAll();
            return listItemBooks;
        } catch (
                Exception ex
        ) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemBook getItemBookById(int id) {
        try {
            ItemBook itemBook = itemBookRepository.findById(id).orElseThrow(() -> new Exception("Not found Book"));
            return itemBook;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void createItemBook(ItemBook itemBook) {
        try {
            itemBookRepository.save(itemBook);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateItemBook(ItemBook itemBook) {
        try {
            itemBookRepository.save(itemBook);

        } catch (Exception ex
        ) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteItemBook(int id) {
        try {
            if (itemBookRepository.existsById(id)) {
                itemBookRepository.deleteById(id);
            }
        } catch (Exception ex
        ) {
            ex.printStackTrace();
        }

    }

}
