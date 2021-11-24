package com.example.sbtickets.controller;

import com.example.sbtickets.bean.ItemBookBean;
import com.example.sbtickets.bean.ItemElectronicBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.*;
import com.example.sbtickets.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemElectronicController {
    @Autowired
    ItemElectronicService itemElectronicService;
    @Autowired
    ElectronicService electronicService;

    @Autowired
    CartService cartService;
    @GetMapping(UrlConst.GET_ITEM_ELECTRONIC)
    public ResponseEntity<WrapperResponse> getItemElectronic(){
        WrapperResponse response = new WrapperResponse();
        List<ItemElectronic> result;
        try {
            result = itemElectronicService.getItemElectronic();
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
    @GetMapping(UrlConst.GET_ITEM_ELECTRONIC_BY_ID)
    public ResponseEntity<WrapperResponse> getElectronicById(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
        ItemElectronic result = null;
        try {
            result = itemElectronicService.getItemElectronicById(id);
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
    @PostMapping(UrlConst.CREATE_ITEM_ELECTRONIC)
    public ResponseEntity<WrapperResponse> createItemElectronic(@RequestBody ItemElectronicBean itemElectronic){
        WrapperResponse response = new WrapperResponse();
        try {
            int electronicId = itemElectronic.getElectronicId();
            Electronic electronic = electronicService.getElectronicById(electronicId);
            int cartId = 1;
            Cart cartItem = cartService.getCart(cartId);
            if(electronic != null){
                ItemElectronic addedItemElectronic = new ItemElectronic(itemElectronic.getBarCode(), itemElectronic.getPrice(),
                        itemElectronic.getSaleoff(), electronic, cartItem);
                itemElectronicService.createItemElectronic(addedItemElectronic);
                response.setMsg("Add Item Electronic Successfully");
                response.setStatus(HttpStatus.OK.value());
            }

        }catch (
                Exception ex
        ){
            ex.printStackTrace();
            response.setMsg("Add Item Electronic Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @PutMapping(UrlConst.UPDATE_ITEM_ELECTRONIC)
    public ResponseEntity<WrapperResponse> updateItemElectronic(@PathVariable (value =  "id") int id,
                                                      @RequestBody ItemElectronicBean itemElectronicBean) throws Exception {
        WrapperResponse response = new WrapperResponse();
        try {
            ItemElectronic itemElectronic = itemElectronicService.getItemElectronicById(id);
            int electronicID = itemElectronicBean.getElectronicId();
            Electronic electronic = electronicService.getElectronicById(electronicID);
            int cartId = 1;
            Cart cartItem = cartService.getCart(cartId);
            ItemElectronic addedItemElectronic = new ItemElectronic(id,itemElectronicBean.getBarCode(), itemElectronicBean.getPrice(),
                    itemElectronicBean.getSaleoff(), electronic, cartItem);
            itemElectronicService.updateItemElectronic(addedItemElectronic);
            response.setMsg("Update Item Electronic Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Update Item Electronic Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @DeleteMapping(UrlConst.DELETE_ITEM_ELECTRONIC)
    public ResponseEntity<WrapperResponse> deleteItemElectronic(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
        try {
            itemElectronicService.deleteItemElectronic(id);
            response.setMsg("Delete Item Electronic Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Delete Item Electronic Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

}
