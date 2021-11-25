package com.example.sbtickets.authentication.entity;

import com.example.sbtickets.entity.Cart;
import com.example.sbtickets.entity.ItemBook;
import com.example.sbtickets.entity.Order;
import org.apache.commons.math3.analysis.function.Add;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Customer_phone")
    private String customerPhone;
    @Column(name = "Mail")
    private String mail;
    @Column(name = "Discriminator")
    private String discriminator;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Cart> cart;

    public Customer() {
    }

    public Customer(String customerPhone, String mail, String discriminator) {
        this.customerPhone = customerPhone;
        this.mail = mail;
        this.discriminator = discriminator;
    }

    public Integer getId() {
        return id;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getMail() {
        return mail;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }
}
