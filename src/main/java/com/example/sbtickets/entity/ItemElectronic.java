package com.example.sbtickets.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="itemelectronic")
public class ItemElectronic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Bar_code")
    private String barCode;
    @Column(name = "Price")
    private Double price;
    @Column(name = "Saleoff")
    private String saleoff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="electronicid")
    private Electronic electronic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="CartID")
    private Cart cart;

    public ItemElectronic() {
    }

    public ItemElectronic(Integer id, String barCode, Double price, String saleoff, Electronic electronic, Cart cart) {
        this.id = id;
        this.barCode = barCode;
        this.price = price;
        this.saleoff = saleoff;
        this.electronic = electronic;
        this.cart = cart;
    }

    public ItemElectronic(String barCode, Double price, String saleoff, Electronic electronic, Cart cart) {
        this.barCode = barCode;
        this.price = price;
        this.saleoff = saleoff;
        this.electronic = electronic;
        this.cart = cart;
    }

    public ItemElectronic(Integer id, String barCode, Double price, String saleoff, Electronic electronic) {
        this.id = id;
        this.barCode = barCode;
        this.price = price;
        this.saleoff = saleoff;
        this.electronic = electronic;
        this.cart = cart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(String saleoff) {
        this.saleoff = saleoff;
    }

}
