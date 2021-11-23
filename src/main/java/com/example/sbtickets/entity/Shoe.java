package com.example.sbtickets.entity;

import javax.persistence.*;

@Entity
@Table(name = "shoe")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Manufacure")
    private String manufacure;
    @Column(name = "Size")
    private Integer size;
    @Column(name = "Material")
    private String material;
    @Column(name = "Color")
    private String color;
    @Column(name = "Style")
    private String style;
    @Column(name = "Image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "ShoeBrandsID")
    private ShoeBrand shoeBrand;


    public Shoe() {
    }

    public Shoe(Integer id, String name, String manufacure, Integer size, String material, String color, String style, String image, ShoeBrand shoeBrand) {
        this.id = id;
        this.name = name;
        this.manufacure = manufacure;
        this.size = size;
        this.material = material;
        this.color = color;
        this.style = style;
        this.image = image;
        this.shoeBrand = shoeBrand;
    }

    public Shoe(String name, String manufacure, Integer size, String material, String color, String style, String image, ShoeBrand shoeBrand) {
        this.name = name;
        this.manufacure = manufacure;
        this.size = size;
        this.material = material;
        this.color = color;
        this.style = style;
        this.image = image;
        this.shoeBrand = shoeBrand;
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

    public String getManufacure() {
        return manufacure;
    }

    public void setManufacure(String manufacure) {
        this.manufacure = manufacure;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ShoeBrand getShoeBrand() {
        return shoeBrand;
    }

    public void setShoeBrand(ShoeBrand shoeBrand) {
        this.shoeBrand = shoeBrand;
    }
}
