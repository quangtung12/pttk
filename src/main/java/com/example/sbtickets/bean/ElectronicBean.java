package com.example.sbtickets.bean;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ElectronicBean {
    private Integer id;
    private Integer itemElectronicID;
    private String name;
    private Date productionDay;
    private String producer;
    private Integer ram;
    private String chip;
    private Float screenSize;
    private Integer pin;
    private Integer storage;
    private Integer hhd;
    private Integer ssd;
    private Integer wattage;
    private String graphicsCard;
    private String Discriminator;
}
