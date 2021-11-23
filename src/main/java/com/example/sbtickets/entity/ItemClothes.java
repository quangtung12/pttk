package com.example.sbtickets.entity;

import javax.persistence.*;

@Entity
@Table(name = "itemclothes")
public class ItemClothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ClothesID")
    private Integer clothesId;
    @Column(name = "CartID")
    private Integer cartId;
    @Column(name = "Bar_code")
    private String bar_code;
    @Column(name = "Price")
    private Double price;
    @Column(name = "Discount_code")
    private String discount_code;

    private Clothes clothes;

    public ItemClothes(Integer id, Integer clothesId, Integer cartId, String bar_code, Double price, String discount_code, Clothes clothes) {
        this.id = id;
        this.clothesId = clothesId;
        this.cartId = cartId;
        this.bar_code = bar_code;
        this.price = price;
        this.discount_code = discount_code;
        this.clothes = clothes;
    }

    public Integer getId() {
        return id;
    }

    public Integer getClothesId() {
        return clothesId;
    }

    public Integer getCartId() {
        return cartId;
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

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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