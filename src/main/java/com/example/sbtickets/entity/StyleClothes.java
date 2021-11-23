package com.example.sbtickets.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "styleclothes")
public class StyleClothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "ID")
    private Integer id;
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "styleClothes")
    private List<Clothes> clothes;

    public StyleClothes() {
    }

    public StyleClothes(String type, List<Clothes> clothes) {
        this.type = type;
        this.clothes = clothes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(List<Clothes> clothes) {
        this.clothes = clothes;
    }
}
