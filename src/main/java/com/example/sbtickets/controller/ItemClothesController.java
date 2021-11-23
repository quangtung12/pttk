package com.example.sbtickets.controller;

import com.example.sbtickets.bean.ItemClothesBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.*;
import com.example.sbtickets.service.CartService;
import com.example.sbtickets.service.ClothesService;
import com.example.sbtickets.service.ItemClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemClothesController {

    @Autowired
    ItemClothesService itemClothesService;

    @Autowired
    ClothesService clothesService;

    @Autowired
    CartService cartService;


    @RequestMapping(value = UrlConst.GET_ITEM_CLOTHES, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> getItemClothes() {
        WrapperResponse response = new WrapperResponse();
        List<ItemClothes> result = new ArrayList<>();
        try {
            result = itemClothesService.getItemClothes();
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

    @RequestMapping(value = UrlConst.GET_ITEM_CLOTHES_ID, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> getItemClothesId(@PathVariable("id") Integer id){
        WrapperResponse response = new WrapperResponse();
        ItemClothes itemClothes;
        try {
            itemClothes = itemClothesService.getItemClothesId(id);
            response.setBody(itemClothes);
            response.setStatus(HttpStatus.OK.value());
        } catch (Exception ex){
            response.setMsg("Cannot find driver");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.CREATE_ITEM_CLOTHES, method = RequestMethod.POST)

    public ResponseEntity<WrapperResponse> createItemClothes(@RequestBody ItemClothesBean itemClothes) {
        WrapperResponse response = new WrapperResponse();
        try{
            int clothesId = itemClothes.getClothesId();
            Clothes clothes = clothesService.getClothesById(clothesId);
            int cartId = 1;
            Cart cartItem = cartService.getCart(cartId);
            if(clothes != null){
                ItemClothes addedItemBook = new ItemClothes(itemClothes.getBar_code(), itemClothes.getPrice(),
                        itemClothes.getDiscount_code(), clothes, cartItem);
                itemClothesService.createItemClothes(addedItemBook);
                response.setMsg("Add Item Clothes Successfully");
                response.setStatus(HttpStatus.OK.value());
            }
        }catch (Exception e) {
            response.setMsg("Cannot add new item clothes");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.UPDATE_ITEM_CLOTHES, method = RequestMethod.PUT)

    public ResponseEntity<WrapperResponse> updateItemClothes(@PathVariable("id") Integer id, @RequestBody ItemClothesBean itemClothesBean) {
        WrapperResponse response = new WrapperResponse();
        try{
            ItemClothes itemclothes = itemClothesService.getItemClothesId(id);
            int clothesId = itemClothesBean.getClothesId();
            Clothes clothes = clothesService.getClothesById(clothesId);
            int cartId = 1;
            Cart cartItem = cartService.getCart(cartId);
            ItemClothes editedItemClothes = new ItemClothes(id,itemClothesBean.getBar_code(),itemClothesBean.getPrice() ,
                    itemClothesBean.getDiscount_code(), clothes, cartItem);
            itemClothesService.updateItemClothes(editedItemClothes);
            response.setMsg("Update Item Clothes Successfully");
            response.setStatus(HttpStatus.OK.value());
        } catch (Exception ex){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMsg("Updated fail");
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.DELETE_ITEM_CLOTHES, method = RequestMethod.DELETE)
    public ResponseEntity<WrapperResponse> deleteItemClothes(@PathVariable("id") Integer id) {
        WrapperResponse response = new WrapperResponse();
        try{
            itemClothesService.deleteItemClothes(id);
            response.setStatus(HttpStatus.OK.value());
            response.setMsg("Deleted successfully");
        } catch (Exception ex){
            response.setMsg(ex.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }


}