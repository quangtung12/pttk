package com.example.sbtickets.controller;

import com.example.sbtickets.bean.ShoeBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.Book;
import com.example.sbtickets.entity.Shoe;
import com.example.sbtickets.entity.ShoeBrand;
import com.example.sbtickets.service.ShoeBrandService;
import com.example.sbtickets.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoeController {
    @Autowired
    ShoeService shoeService;
    @Autowired
    ShoeBrandService shoeBrandService;

    @RequestMapping(value = UrlConst.GET_SHOE, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> getShoe() {
        WrapperResponse response = new WrapperResponse();
        List<Shoe> result = new ArrayList<>();
        try {
            result = shoeService.getShoe();
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

    @RequestMapping(value = UrlConst.GET_SHOE_BY_ID, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> getShoeById(@PathVariable("id") Integer id){
        WrapperResponse response = new WrapperResponse();
        Shoe shoe;
        try {
            shoe = shoeService.getShoeById(id);
            response.setBody(shoe);
            response.setStatus(HttpStatus.OK.value());
        } catch (Exception ex){
            response.setMsg("Cannot find Shoe");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.CREATE_SHOE, method = RequestMethod.POST)
    public ResponseEntity<WrapperResponse>  createBook(@RequestBody ShoeBean shoe){
        WrapperResponse response = new WrapperResponse();
        try {
            Integer shoeBrandId = shoe.getShoeBrandId();
            ShoeBrand shoeBrand = shoeBrandService.getShoeBrandById(shoeBrandId);
            if(shoeBrand != null){
                Shoe addedShoe = new Shoe(
                        shoe.getName(),
                        shoe.getManufacure(),
                        shoe.getSize(),
                        shoe.getMaterial(),
                        shoe.getColor(),
                        shoe.getStyle(),
                        shoe.getImage(),
                        shoeBrand
                );
                shoeService.createShoe(addedShoe);
                response.setMsg("Add Shoe Successfully");
                response.setStatus(HttpStatus.OK.value());
            }

        }catch (
                Exception ex
        ){
            ex.printStackTrace();
            response.setMsg("Add Shoe Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
    @RequestMapping(value = UrlConst.UPDATE_SHOE, method = RequestMethod.PUT)
    public ResponseEntity<WrapperResponse> updateShoe(@PathVariable (value =  "id") Integer id, @RequestBody ShoeBean shoe) throws Exception {
        WrapperResponse response = new WrapperResponse();
        try {
            Integer shoeBrandId = shoe.getShoeBrandId();
            ShoeBrand shoeBrand = shoeBrandService.getShoeBrandById(shoeBrandId);
            Shoe editedShoe = new Shoe(
                    id,
                    shoe.getName(),
                    shoe.getManufacure(),
                    shoe.getSize(),
                    shoe.getMaterial(),
                    shoe.getColor(),
                    shoe.getStyle(),
                    shoe.getImage(),
                    shoeBrand

            );
            shoeService.updateShoe(id,editedShoe);
            response.setMsg("Update Shoe Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Add Shoe Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.DELETE_SHOE, method = RequestMethod.DELETE)
    public ResponseEntity<WrapperResponse> deleteShoe(@PathVariable(value = "id") Integer id){
        WrapperResponse response = new WrapperResponse();
        try {
            shoeService.deleteShoe(id);
            response.setMsg("Delete Shoe Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Delete Shoe Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
}
