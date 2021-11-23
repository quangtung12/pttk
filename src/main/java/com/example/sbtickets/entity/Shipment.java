package com.example.sbtickets.entity;

import com.example.sbtickets.authentication.entity.Customer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Method")
    private String method;
    @Column(name = "Ship_price")
    private String ship_price;
    @Column(name = "Type")
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderID", referencedColumnName = "ID")
    private Order order;

    public Shipment() {
    }

    public Shipment(Integer id, String method, String ship_price, String type, Order order) {
        this.id = id;
        this.method = method;
        this.ship_price = ship_price;
        this.type = type;
        this.order = order;
    }
}
