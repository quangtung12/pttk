package com.example.sbtickets.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="itemshoe")
@Getter
@Setter
public class ItemShoe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Bar_code")
    private String barCode;
    @Column(name = "Price")
    private double price;
    @Column(name = "Note")
    private String note;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ShoeID")
    private Shoe shoe;

    public ItemShoe() {
    }

    public ItemShoe(String barCode, double price, String note, Shoe shoe) {
        this.barCode = barCode;
        this.price = price;
        this.note = note;
        this.shoe = shoe;
    }

    public ItemShoe(Integer id, String barCode, double price, String note, Shoe shoe) {
        this.id = id;
        this.barCode = barCode;
        this.price = price;
        this.note = note;
        this.shoe = shoe;
    }
}
