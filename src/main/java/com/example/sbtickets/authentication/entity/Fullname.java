package com.example.sbtickets.authentication.entity;

import javax.persistence.*;

@Entity
@Table(name = "fullName")
public class Fullname {
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

    public Fullname() {
    }

    public Fullname(Customer customer, String lastName, String middleName, String firstName) {
        this.customer = customer;
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
