package com.example.sbtickets.entity;

import com.example.sbtickets.authentication.entity.Customer;

import javax.persistence.*;

@Entity
@Table(name = "ordercart")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CartID", referencedColumnName = "ID")
    private Cart cart;
    @Column(name = "Total_price")
    private Double total_price;
    @Column(name = "Tax_price")
    private Double tax_price;
    @Column(name = "Discount_code")
    private String discount_code;
    @Column(name = "Shipcode")
    private String shipcode;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "midle_name")
    private String midle_name;

    public Order() {
    }

    public Order(Integer id, Customer customer, Cart cart, Double total_price, Double tax_price, String discount_code, String shipcode, String first_name, String last_name, String midle_name) {
        this.id = id;
        this.customer = customer;
        this.cart = cart;
        this.total_price = total_price;
        this.tax_price = tax_price;
        this.discount_code = discount_code;
        this.shipcode = shipcode;
        this.first_name = first_name;
        this.last_name = last_name;
        this.midle_name = midle_name;
    }

    public Order(Customer customer, Cart cart, Double total_price, Double tax_price, String discount_code, String shipcode, String first_name, String last_name, String midle_name) {
        this.customer = customer;
        this.cart = cart;
        this.total_price = total_price;
        this.tax_price = tax_price;
        this.discount_code = discount_code;
        this.shipcode = shipcode;
        this.first_name = first_name;
        this.last_name = last_name;
        this.midle_name = midle_name;
    }
}
