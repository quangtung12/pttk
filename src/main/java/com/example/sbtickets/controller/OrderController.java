package com.example.sbtickets.controller;

import com.example.sbtickets.authentication.entity.Customer;
import com.example.sbtickets.authentication.service.CustomerDAO;
import com.example.sbtickets.bean.CartItemBean;
import com.example.sbtickets.bean.OrderBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.Cart;
import com.example.sbtickets.entity.ItemBook;
import com.example.sbtickets.entity.Order;
import com.example.sbtickets.service.CartService;
import com.example.sbtickets.service.CustomerService;
import com.example.sbtickets.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CartService cartService;

    @RequestMapping(UrlConst.CREATE_ORDER)
    public ResponseEntity<WrapperResponse> createOrder(@RequestBody OrderBean orderBean){
        WrapperResponse response = new WrapperResponse();
        try {
            int cartId = orderBean.getCartId();
            Cart cart = cartService.getCart(cartId);
            Customer customer = customerService.findCustomer(orderBean.getCusId());
            Order order = new Order(customer, cart, orderBean.getTotal_price(), orderBean.getTax_price(),
                    orderBean.getDiscount_code(), orderBean.getShipcode(), orderBean.getFirst_name(), orderBean.getLast_name(),
                    orderBean.getMidle_name());
            orderService.createOrder(order);
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
