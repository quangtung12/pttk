package com.example.sbtickets.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderBean {
    private Integer cusId;
    private Integer cartId;
    private Double total_price;
    private Double tax_price;
    private String discount_code;
    private String shipcode;
    private String first_name;
    private String last_name;
    private String midle_name;
}
