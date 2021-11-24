package com.example.sbtickets.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "electronic")
public class Electronic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Producer")
    private String Producer;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Type")
    private String Type;
    @Column(name = "Producer_date")
    private Date Producer_date;
    @Column(name = "Ram")
    private String Ram;
    @Column(name = "Cpu")
    private  String Cpu;
    @Column(name = "Screen")
    private  String Screen;
    @Column(name = "Keyboard")
    private  String Keyboard;
    @Column(name = "Image")
    private String image;

    @OneToMany(mappedBy = "electronic")
    private List<ItemElectronic> itemElectronic;

    public Electronic() {
    }

    public Electronic(String producer, String name, String type, Date producer_date, String ram, String cpu, String screen, String keyboard, String image) {
    }

    public Electronic(Integer id, String producer, String name, String type, Date producer_date, String ram, String cpu, String screen, String keyboard) {
        this.id = id;
        Producer = producer;
        Name = name;
        Type = type;
        Producer_date = producer_date;
        Ram = ram;
        Cpu = cpu;
        Screen = screen;
        Keyboard = keyboard;
    }

    public Integer getId() {
        return id;
    }

    public String getProducer() {
        return Producer;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public Date getProducer_date() {
        return Producer_date;
    }

    public String getRam() {
        return Ram;
    }

    public String getCpu() {
        return Cpu;
    }

    public String getScreen() {
        return Screen;
    }

    public String getKeyboard() {
        return Keyboard;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setProducer_date(Date producer_date) {
        Producer_date = producer_date;
    }

    public void setRam(String ram) {
        Ram = ram;
    }

    public void setCpu(String cpu) {
        Cpu = cpu;
    }

    public void setScreen(String screen) {
        Screen = screen;
    }

    public void setKeyboard(String keyboard) {
        Keyboard = keyboard;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ItemElectronic> getItemElectronic() {
        return itemElectronic;
    }

    public void setItemElectronic(List<ItemElectronic> itemElectronic) {
        this.itemElectronic = itemElectronic;
    }
}
