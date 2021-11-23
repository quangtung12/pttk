package com.example.sbtickets.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shoebrands")
public class ShoeBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email_contact")
    private String email;

    @OneToMany(mappedBy = "shoeBrand")
    private List<Shoe> shoes;

    public ShoeBrand() {
    }

    public ShoeBrand(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
