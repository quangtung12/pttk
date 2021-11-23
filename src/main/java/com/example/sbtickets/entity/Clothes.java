package com.example.sbtickets.entity;

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
    @JoinColumn(name = "style_clothesID")
    private StyleClothes styleClothes;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "clothes_brandsID")
    private ClothesBrands clothesBrand;

    public Clothes() {
    }

    public Clothes(Integer id, String name, String manufacture, String size, String material, String color, String image) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
        this.size = size;
        this.material = material;
        this.color = color;
        this.image = image;
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
}
