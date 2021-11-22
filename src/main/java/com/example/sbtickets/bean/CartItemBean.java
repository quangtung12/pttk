package com.example.sbtickets.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
public class CartItemBean {
    private Integer cartId;
    private Integer itemId;
    private String  typeItem;
}
