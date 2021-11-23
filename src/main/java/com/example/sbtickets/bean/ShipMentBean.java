package com.example.sbtickets.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipMentBean {
    private int id;
    private int orderId;
    private String method;
    private String shipPrice;
    private String type;
}
