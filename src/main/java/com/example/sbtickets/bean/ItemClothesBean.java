package com.example.sbtickets.bean;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ItemClothesBean {
    private Integer id;
    private Integer clothesId;
    private Integer cartId;
    private String bar_code;
    private Double price;
    private String discount_code;

}
