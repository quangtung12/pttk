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
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "midle_name")
    private String middleName;
    @Column(name = "first_name")
    private String firstName;
}
