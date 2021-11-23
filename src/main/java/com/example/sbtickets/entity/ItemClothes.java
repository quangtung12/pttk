package com.example.sbtickets.entity;

import javax.persistence.*;

@Entity
@Table(name = "itemclothes")
public class ItemClothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "bar_code")
    private String bar_code;
    @Column(name = "price")
    private Double price;
    @Column(name = "discount_code")
    private String discount_code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClothesID")
    private Clothes clothes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="CartID")
    private Cart cart;

    public ItemClothes() {
    }

    public ItemClothes(String bar_code, Double price, String discount_code, Clothes clothes) {
        this.bar_code = bar_code;
        this.price = price;
        this.discount_code = discount_code;
        this.clothes = clothes;
    }

    public ItemClothes(String bar_code, Double price, String discount_code, Clothes clothes, Cart cart) {
        this.bar_code = bar_code;
        this.price = price;
        this.discount_code = discount_code;
        this.clothes = clothes;
        this.cart = cart;
    }

    public ItemClothes(Integer id, String bar_code, Double price, String discount_code, Clothes clothes) {
        this.id = id;
        this.bar_code = bar_code;
        this.price = price;
        this.discount_code = discount_code;
        this.clothes = clothes;
    }

    public ItemClothes(Integer id, String bar_code, Double price, String discount_code, Clothes clothes, Cart cart) {
        this.id = id;
        this.bar_code = bar_code;
        this.price = price;
        this.discount_code = discount_code;
        this.clothes = clothes;
        this.cart = cart;
    }

    public Integer getId() {
        return id;
    }

    public String getBar_code() {
        return bar_code;
    }

    public Double getPrice() {
        return price;
    }

    public String getDiscount_code() {
        return discount_code;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }
}