package com.example.sbtickets.controller;

import com.example.sbtickets.bean.CartItemBean;
import com.example.sbtickets.bean.ItemBookBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.*;
import com.example.sbtickets.repository.BookRespository;
import com.example.sbtickets.service.*;
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

    @Autowired
    ItemShoeService itemShoeService;

    @Autowired
    ItemClothesService itemClothesService;

    @Autowired
    ItemElectronicService itemElectronicService;

    @PostMapping(UrlConst.ADD_TO_CART)
    public ResponseEntity<WrapperResponse> addToCart(@RequestBody CartItemBean cartItemBean){
        WrapperResponse response = new WrapperResponse();
        try {
            int cartId = cartItemBean.getCartId();
            Cart cart = cartService.getCart(cartId);
            ItemBook itembook = new ItemBook();
            ItemShoe itemShoe = new ItemShoe();
            ItemClothes itemClothes = new ItemClothes();
            ItemElectronic itemElectronic = new ItemElectronic();
            if(cartItemBean.getTypeItem().equals("Book")){
                itembook = itemBookService.getItemBookById(cartItemBean.getItemId());
                cart.getItemBooks().add(itembook);
                itembook.setCart(cart);
                cartService.insertItem(cart);
                itemBookService.updateItemBook(itembook);
            } else if (cartItemBean.getTypeItem().equals("Shoe")) {
                itemShoe = itemShoeService.getItemShoeById(cartItemBean.getItemId());
                cart.getItemShoes().add(itemShoe);
                itemShoe.setCart(cart);
                cartService.insertItem(cart);
                itemShoeService.updateItemShoe(itemShoe);
            } else if (cartItemBean.getTypeItem().equals("Clothes")) {
                itemClothes = itemClothesService.getItemClothesId(cartItemBean.getItemId());
                cart.getItemClothes().add(itemClothes);
                itemClothes.setCart(cart);
                cartService.insertItem(cart);
                itemClothesService.updateItemClothes(itemClothes);
            } else if (cartItemBean.getTypeItem().equals("Electronic")) {
                itemElectronic = itemElectronicService.getItemElectronicById(cartItemBean.getItemId());
                cart.getItemElectronic().add(itemElectronic);
                itemElectronic.setCart(cart);
                cartService.insertItem(cart);
                itemElectronicService.updateItemElectronic(itemElectronic);
            }
            response.setMsg("Add To Cart Successfully");
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

    @PostMapping(UrlConst.DELETE_TO_CART)
    public ResponseEntity<WrapperResponse> deleteItemCart(@RequestBody CartItemBean cartItemBean){
        WrapperResponse response = new WrapperResponse();
        try {
            int carId = cartItemBean.getCartId();
            ItemBook itembook = new ItemBook();
            if(cartItemBean.getTypeItem().equals("Book")){
                itembook = itemBookService.getItemBookById(cartItemBean.getItemId());
                itemBookService.deleteBook(itembook);
            }
            response.setMsg("Delete To Cart Book Successfully");
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
