package com.example.sbtickets.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ShoeBean {
    private Integer id;
    private String name;
    private String manufacure;
    private Integer size;
    private String material;
    private String color;
    private String style;
    private String image;
    private Integer shoeBrandId;
}
