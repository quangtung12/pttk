package com.example.sbtickets.controller;

import com.example.sbtickets.bean.CartItemBean;
import com.example.sbtickets.bean.ItemBookBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.Book;
import com.example.sbtickets.entity.Cart;
import com.example.sbtickets.entity.ItemBook;
import com.example.sbtickets.repository.BookRespository;
import com.example.sbtickets.service.BookService;
import com.example.sbtickets.service.CartService;
import com.example.sbtickets.service.ItemBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    CartService cartService;


    @Autowired
    ItemBookService itemBookService;

    @PostMapping(UrlConst.ADD_TO_CART)
    public ResponseEntity<WrapperResponse> createItemBook(@RequestBody CartItemBean cartItemBean){
        WrapperResponse response = new WrapperResponse();
        try {
            int carId = cartItemBean.getCartId();
            ItemBook itembook = new ItemBook();
            if(cartItemBean.getTypeItem().equals("Book")){
                itembook = itemBookService.getItemBookById(cartItemBean.getItemId());
            }
            Cart cart = cartService.getCart(carId);
            cart.getItemBooks().add(itembook);
            itembook.setCart(cart);
            cartService.insertItemBook(cart);
            itemBookService.updateItemBook(itembook);
            response.setMsg("Add To Cart Book Successfully");
            response.setStatus(HttpStatus.OK.value());
        }catch (
                Exception ex
        ){
            ex.printStackTrace();
            response.setMsg("Add Item Book Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
}
