package com.example.sbtickets.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="itembook")
@Getter
@Setter
public class ItemBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Bar_code")
    private String barCode;
    @Column(name = "Price")
    private double price;
    @Column(name = "Discount_code")
    private String discountCode;
    @Column(name = "Note")
    private String note;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="BookID")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="CartID")
    private Cart cart;

    public ItemBook() {
    }

    public ItemBook(String barCode, double price, String discountCode, String note, Book book) {
        this.barCode = barCode;
        this.price = price;
        this.discountCode = discountCode;
        this.note = note;
        this.book = book;
    }

    public ItemBook(String barCode, double price, String discountCode, String note, Book book, Cart cart) {
        this.barCode = barCode;
        this.price = price;
        this.discountCode = discountCode;
        this.note = note;
        this.book = book;
        this.cart = cart;
    }

    public ItemBook(Integer id, String barCode, double price, String discountCode, String note, Book book) {
        this.id = id;
        this.barCode = barCode;
        this.price = price;
        this.discountCode = discountCode;
        this.note = note;
        this.book = book;
    }
}
