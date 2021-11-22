package com.example.sbtickets.controller;

import com.example.sbtickets.bean.BookBean;
import com.example.sbtickets.bean.ItemBookBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.Book;
import com.example.sbtickets.entity.Cart;
import com.example.sbtickets.entity.ItemBook;
import com.example.sbtickets.entity.Publisher;
import com.example.sbtickets.service.BookService;
import com.example.sbtickets.service.CartService;
import com.example.sbtickets.service.ElectronicService;
import com.example.sbtickets.service.ItemBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemBookController {
    @Autowired
    ItemBookService itemBookService;
    @Autowired
    BookService bookService;

    @Autowired
    CartService cartService;
    @GetMapping(UrlConst.GET_ITEM_BOOKS)
    public ResponseEntity<WrapperResponse> getItemBooks(){
        WrapperResponse response = new WrapperResponse();
        List<ItemBook> result;
        try {
            result = itemBookService.getItemBooks();
            response.setBody(result);
            response.setStatus(HttpStatus.OK.value());
        }
        catch (Exception ex){
            response.setMsg("Not found");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
    @GetMapping(UrlConst.GET_ITEM_BOOK_BY_ID)
    public ResponseEntity<WrapperResponse> getBookById(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
        ItemBook result = null;
        try {
            result = itemBookService.getItemBookById(id);
            response.setBody(result);
            response.setStatus(HttpStatus.OK.value());
        }catch (
                Exception ex
        ){
            response.setMsg("Not found");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
    @PostMapping(UrlConst.CREATE_ITEM_BOOK)
    public ResponseEntity<WrapperResponse> createItemBook(@RequestBody ItemBookBean itemBook){
        WrapperResponse response = new WrapperResponse();
        try {
            int bookId = itemBook.getBookId();
            Book book = bookService.getBookById(bookId);
            int cartId = 1;
            Cart cartItem = cartService.getCart(cartId);
            if(book != null){
                ItemBook addedItemBook = new ItemBook(itemBook.getBarCode(), itemBook.getPrice(),
                        itemBook.getDiscountCode(), itemBook.getNote(), book, cartItem);
                itemBookService.createItemBook(addedItemBook);
                response.setMsg("Add Item Book Successfully");
                response.setStatus(HttpStatus.OK.value());
            }

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

    @PutMapping(UrlConst.UPDATE_ITEM_BOOK)
    public ResponseEntity<WrapperResponse> updateBook(@PathVariable (value =  "id") int id,
                                                      @RequestBody ItemBookBean itemBookBean) throws Exception {
        WrapperResponse response = new WrapperResponse();
        try {
            ItemBook itemBook = itemBookService.getItemBookById(id);
            int bookId = itemBookBean.getBookId();
            Book book = bookService.getBookById(bookId);
            ItemBook editedItemBook = new ItemBook(id,itemBookBean.getBarCode(),itemBookBean.getPrice() ,
                    itemBookBean.getDiscountCode(),itemBookBean.getNote(), book);
            itemBookService.updateItemBook(editedItemBook);
            response.setMsg("Update Item Book Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Add Item Book Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @DeleteMapping(UrlConst.DELETE_ITEM_BOOK)
    public ResponseEntity<WrapperResponse> deleteBook(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
        try {
            itemBookService.deleteItemBook(id);
            response.setMsg("Delete Item Book Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Delete Item Book Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }



}
