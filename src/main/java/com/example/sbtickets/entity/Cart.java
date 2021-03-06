package com.example.sbtickets.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Amount")
    private String amount;
    @Column(name = "Item")
    private String item;
    @Column(name = "Total_price")
    private Integer totalPrice;

    @OneToMany(mappedBy = "cart")
    private List<ItemBook> itemBooks;

    @OneToMany(mappedBy = "cart")
    private List<ItemShoe> itemShoes;

    @OneToMany(mappedBy = "cart")
    private List<ItemClothes> itemClothes;

    @OneToMany(mappedBy = "cart")
    private List<ItemElectronic> itemElectronic;

    @OneToOne(mappedBy = "cart")
    private Order order;

    public Cart() {
    }

    public Cart(Integer id, String amount, String item, Integer totalPrice, List<ItemBook> itemBooks, List<ItemShoe> itemShoes) {
        this.id = id;
        this.amount = amount;
        this.item = item;
        this.totalPrice = totalPrice;
        this.itemBooks = itemBooks;
        this.itemShoes = itemShoes;
    }

    public Cart(String amount, String item, Integer totalPrice, List<ItemBook> itemBooks, List<ItemShoe> itemShoes, List<ItemClothes> itemClothes, List<ItemElectronic> itemElectronic) {
        this.amount = amount;
        this.item = item;
        this.totalPrice = totalPrice;
        this.itemBooks = itemBooks;
        this.itemShoes = itemShoes;
        this.itemClothes = itemClothes;
        this.itemElectronic = itemElectronic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ItemBook> getItemBooks() {
        return itemBooks;
    }

    public void setItemBooks(List<ItemBook> itemBooks) {
        this.itemBooks = itemBooks;
    }

    public List<ItemShoe> getItemShoes() {
        return itemShoes;
    }

    public void setItemShoes(List<ItemShoe> itemShoes) {
        this.itemShoes = itemShoes;
    }

    public List<ItemClothes> getItemClothes() {
        return itemClothes;
    }

    public void setItemClothes(List<ItemClothes> itemClothes) {
        this.itemClothes = itemClothes;
    }

    public List<ItemElectronic> getItemElectronic() {
        return itemElectronic;
    }

    public void setItemElectronic(List<ItemElectronic> itemElectronic) {
        this.itemElectronic = itemElectronic;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
