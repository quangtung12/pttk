//package com.example.sbtickets.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name ="itembook")
//@Getter
//@Setter
//public class ItemBook {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID")
//    private Integer id;
//    @Column(name = "Bar_code")
//    private String barCode;
//    @Column(name = "Price")
//    private double price;
//    @Column(name = "Discount_code")
//    private String discountCode;
//    @Column(name = "Note")
//    private String note;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="BookID")
//    private Book book;
//}
