package com.example.sbtickets.controller;

import com.example.sbtickets.bean.ShipMentBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.*;
import com.example.sbtickets.service.OrderService;
import com.example.sbtickets.service.ShipMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShipMentController {

    @Autowired
    ShipMentService shipMentService;

    @Autowired
    OrderService orderService;

    @PutMapping(value = UrlConst.FIND_SHIPMENT)
    public ResponseEntity<WrapperResponse> findShipMent(@PathVariable(value =  "id") int id){
        WrapperResponse response = new WrapperResponse();
        try {
            response.setBody(shipMentService.findShipMent(id));
            response.setMsg("Find Item Book Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Find ShipMent Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response,HttpStatus.OK);
    }

    @PostMapping(value = UrlConst.EDIT_SHIPMENT)
    public ResponseEntity<WrapperResponse> editShipMent(@RequestBody ShipMentBean shipMentBean){
        WrapperResponse response = new WrapperResponse();
        try {
            Shipment shipment = new Shipment(shipMentBean.getId(),shipMentBean.getMethod(), shipMentBean.getShipPrice(), shipMentBean.getType(), orderService.getOrderById(shipMentBean.getOrderId()));
            shipMentService.updateShipMent(shipment);
            response.setMsg("Edit Ship Ment Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Find ShipMent Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response,HttpStatus.OK);
    }
}
