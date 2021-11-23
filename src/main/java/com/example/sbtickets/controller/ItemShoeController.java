package com.example.sbtickets.controller;

import com.example.sbtickets.bean.ShoeBean;
import com.example.sbtickets.bean.ItemShoeBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.Shoe;
import com.example.sbtickets.entity.ItemShoe;
import com.example.sbtickets.service.BookService;
import com.example.sbtickets.service.ItemShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemShoeController {
    @Autowired
    ItemShoeService itemShoeService;
    @Autowired
    ShoeService shoeService;
    @GetMapping(UrlConst.GET_ITEM_SHOES)
    public ResponseEntity<WrapperResponse> getItemShoes(){
        WrapperResponse response = new WrapperResponse();
        List<ItemShoe> result;
        try {
            result = itemShoeService.getItemShoes();
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
    @GetMapping(UrlConst.GET_ITEM_SHOE_BY_ID)
    public ResponseEntity<WrapperResponse> getShoeById(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
        ItemShoe result = null;
        try {
            result = itemShoeService.getItemShoeById(id);
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
    @PostMapping(UrlConst.CREATE_ITEM_SHOE)
    public ResponseEntity<WrapperResponse> createItemShoe(@RequestBody ItemShoeBean itemShoe){
        WrapperResponse response = new WrapperResponse();
        try {
            int shoeId = itemShoe.getShoeId();
            Shoe shoe = shoeService.getShoeById(shoeId);
            if(shoe != null){
                ItemShoe addedItemShoe = new ItemShoe(itemShoe.getBarCode(), itemShoe.getPrice(),
                        itemShoe.getNote(), shoe);
                itemShoeService.createItemShoe(addedItemShoe);
                response.setMsg("Add Item Shoe Successfully");
                response.setStatus(HttpStatus.OK.value());
            }

        }catch (
                Exception ex
        ){
            ex.printStackTrace();
            response.setMsg("Add Item Shoe Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @PutMapping(UrlConst.UPDATE_ITEM_SHOE)
    public ResponseEntity<WrapperResponse> updateShoe(@PathVariable (value =  "id") int id,
                                                      @RequestBody ItemShoeBean itemShoeBean) throws Exception {
        WrapperResponse response = new WrapperResponse();
        try {
            ItemShoe itemShoe = itemShoeService.getItemShoeById(id);
            int shoeId = itemShoeBean.getShoeId();
            Shoe shoe = shoeService.getShoeById(shoeId);
            ItemShoe editedItemShoe = new ItemShoe(id,itemShoeBean.getBarCode(),itemShoeBean.getPrice() ,
                    itemShoeBean.getNote(), shoe);
            itemShoeService.updateItemShoe(editedItemShoe);
            response.setMsg("Update Item Shoe Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Add Item Shoe Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @DeleteMapping(UrlConst.DELETE_ITEM_SHOE)
    public ResponseEntity<WrapperResponse> deleteShoe(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
        try {
            itemShoeService.deleteItemShoe(id);
            response.setMsg("Delete Item Shoe Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Delete Item Shoe Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }



}

