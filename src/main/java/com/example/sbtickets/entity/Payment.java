package com.example.sbtickets.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name ="OrderID2")
    private Integer orderID2;
    @Column(name = "Method")
    private String method;
    @Column(name = "Name")
    private String name;
    @Column(name = "BankID")
    private Integer bankID;
    @Column(name = "CashTendered")
    private Integer cashTendered;
    @Column(name = "Number")
    private  Integer number;
    @Column(name = "Type")
    private String type;
    @Column(name = "ExpDate")
    private Date expDate;
    @Column(name = "Discriminator")
    private String discriminator;

    public Payment() {
    }

    public Payment(Integer id, Integer orderID2, String method, String name, Integer bankID, Integer cashTendered, Integer number, String type, Date expDate, String publicationDate) {
        this.id = id;
        this.orderID2 = orderID2;
        this.method = method;
        this.name = name;
        this.bankID = bankID;
        this.cashTendered = cashTendered;
        this.number = number;
        this.type = type;
        this.expDate = expDate;
        this.discriminator = publicationDate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrderID2() {
        return orderID2;
    }

    public String getMethod() {
        return method;
    }

    public String getName() {
        return name;
    }

    public Integer getBankID() {
        return bankID;
    }

    public Integer getCashTendered() {
        return cashTendered;
    }

    public Integer getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Date getExpDate() {
        return expDate;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrderID2(Integer orderID2) {
        this.orderID2 = orderID2;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBankID(Integer bankID) {
        this.bankID = bankID;
    }

    public void setCashTendered(Integer cashTendered) {
        this.cashTendered = cashTendered;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }
}
