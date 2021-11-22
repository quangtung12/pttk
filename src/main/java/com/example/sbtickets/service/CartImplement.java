package com.example.sbtickets.service;

import com.example.sbtickets.entity.Cart;
import com.example.sbtickets.entity.ItemBook;

public interface CartImplement {
    public Cart getCart(Integer id);

    public void insertItemBook(Cart cart);
}
