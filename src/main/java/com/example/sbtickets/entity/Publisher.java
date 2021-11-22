package com.example.sbtickets.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pulisher")
@Getter
@Setter
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name ="Address")
    private String address;
    @Column(name = "Email")
    private String email;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
    public Publisher() {
    }

    public Publisher(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }


}
