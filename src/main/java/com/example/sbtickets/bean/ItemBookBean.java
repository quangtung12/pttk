package com.example.sbtickets.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemBookBean {
    private String barCode;
    private Double price;
    private String discountCode;
    private String note;
    private Integer bookId;
}
