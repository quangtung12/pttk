package com.example.sbtickets.service;

import com.example.sbtickets.entity.Cart;
import com.example.sbtickets.entity.ItemBook;
import com.example.sbtickets.repository.TRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CartService implements CartImplement{

    @Autowired
    TRespository tRespository;

    @Override
    public Cart getCart(Integer id) {
        return tRespository.findById(id).get();
    }

    @Override
    public void insertItemBook(Cart cart) {
        tRespository.save(cart);
    }

    @Override
    public void deleteItemBook(Cart cart) {
        tRespository.delete(cart);
    }


}
