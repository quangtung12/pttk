package com.example.sbtickets.controller;

import com.example.sbtickets.bean.ElectronicBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.Cart;
import com.example.sbtickets.entity.Electronic;
import com.example.sbtickets.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ElectronicController {
    @Autowired
    ElectronicService electronicService;

    @RequestMapping(value = UrlConst.GET_ELECTRONIC, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> getElectronic() {
        WrapperResponse response = new WrapperResponse();
        List<Electronic> result = new ArrayList<>();
        try {
            result = electronicService.getElectronic();
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
    @GetMapping(UrlConst.GET_ELECTRONIC_BY_ID)
    public ResponseEntity<WrapperResponse> getElectronicById(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
        Electronic result = null;
        try {
            result = electronicService.getElectronicById(id);
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
    @PostMapping(UrlConst.CREATE_ELECTRONIC)
    public ResponseEntity<WrapperResponse> createElectronic(@RequestBody ElectronicBean electronic){
        WrapperResponse response = new WrapperResponse();
        try {
            if(electronic != null){
                Electronic addedElectronic = new Electronic(electronic.getProducer(), electronic.getName(),
                        electronic.getType(),electronic.getProducer_date(),electronic.getRam(),electronic.getCpu(),electronic.getScreen(),electronic.getKeyboard(),electronic.getImage());
                electronicService.createElectronic(addedElectronic);
                response.setMsg("Add Electronic Successfully");
                response.setStatus(HttpStatus.OK.value());
            }

        }catch (
                Exception ex
        ){
            ex.printStackTrace();
            response.setMsg("Add Electronic Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @PutMapping(UrlConst.UPDATE_ELECTRONIC)
    public ResponseEntity<WrapperResponse> updateElectronic(@PathVariable (value =  "id") int id,
                                                      @RequestBody ElectronicBean electronicBean) throws Exception {
        WrapperResponse response = new WrapperResponse();
        try {
            Electronic electronic = electronicService.getElectronicById(id);
            Electronic addedElectronic = new Electronic(electronic.getProducer(), electronic.getName(),
                    electronic.getType(),electronic.getProducer_date(),electronic.getRam(),electronic.getCpu(),electronic.getScreen(),electronic.getKeyboard(),electronic.getImage());
            electronicService.updateElectronic(addedElectronic);
            response.setMsg("Update Electronic Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Add Electronic Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @DeleteMapping(UrlConst.DELETE_ELECTRONIC)
    public ResponseEntity<WrapperResponse> deleteElectronic(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
        try {
            electronicService.deleteElectronic(id);
            response.setMsg("Delete Electronic Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Delete Electronic Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
}
