package com.example.sbtickets.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Manufacture")
    private String manufacture;
    @Column(name = "Size")
    private String size;
    @Column(name = "Material")
    private  String material;
    @Column(name = "Color")
    private  String color;
    @Column(name = "Image")
    private String image;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "style_clothesid")
    private StyleClothes styleclothes;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "clothes_brandsid")
    private ClothesBrands clothesbrands;

    public Clothes() {
    }

    public Clothes(Integer id, StyleClothes style, ClothesBrands brands, String name, String manufacture, String size, String material, String color, String image) {
        this.id = id;
        this.styleclothes = style;
        this.clothesbrands = brands;
        this.name = name;
        this.manufacture = manufacture;
        this.size = size;
        this.material = material;
        this.color = color;
        this.image = image;
    }

    public Clothes(Integer id, String name, String manufacture, String size, String material, String color, String image, StyleClothes styleclothes, ClothesBrands clothesbrands) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
        this.size = size;
        this.material = material;
        this.color = color;
        this.image = image;
        this.styleclothes = styleclothes;
        this.clothesbrands = clothesbrands;
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

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StyleClothes getStyleclothes() {
        return styleclothes;
    }

    public void setStyleclothes(StyleClothes styleclothes) {
        this.styleclothes = styleclothes;
    }

    public ClothesBrands getClothesbrands() {
        return clothesbrands;
    }

    public void setClothesbrands(ClothesBrands clothesbrands) {
        this.clothesbrands = clothesbrands;
    }
}
