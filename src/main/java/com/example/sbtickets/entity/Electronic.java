package com.example.sbtickets.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Electronic")
public class Electronic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "itemElectronicID")
    private Integer itemElectronicID;
    @Column(name = "name")
    private String name;
    @Column(name = "productionDay")
    private Date productionDay;
    @Column(name = "producer")
    private String producer;
    @Column(name = "ram")
    private Integer ram;
    @Column(name = "chip")
    private String chip;
    @Column(name = "screenSize")
    private Float screenSize;
    @Column(name = "pin")
    private Integer pin;
    @Column(name = "storage")
    private Integer storage;
    @Column(name = "hhd")
    private Integer hhd;
    @Column(name = "ssd")
    private Integer ssd;
    @Column(name = "wattage")
    private Integer wattage;
    @Column(name = "graphicsCard")
    private String graphicsCard;
    @Column(name = "Discriminator")
    private String Discriminator;

    public Electronic() {
    }

    public Electronic(Integer id, Integer itemElectronicID, String name, Date productionDay, String producer, Integer ram, String chip, Float screenSize, Integer pin, Integer storage, Integer hhd, Integer ssd, Integer wattage, String graphicsCard, String discriminator) {
        this.id = id;
        this.itemElectronicID = itemElectronicID;
        this.name = name;
        this.productionDay = productionDay;
        this.producer = producer;
        this.ram = ram;
        this.chip = chip;
        this.screenSize = screenSize;
        this.pin = pin;
        this.storage = storage;
        this.hhd = hhd;
        this.ssd = ssd;
        this.wattage = wattage;
        this.graphicsCard = graphicsCard;
        Discriminator = discriminator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemElectronicID() {
        return itemElectronicID;
    }

    public void setItemElectronicID(Integer itemElectronicID) {
        this.itemElectronicID = itemElectronicID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProductionDay() {
        return productionDay;
    }

    public void setProductionDay(Date productionDay) {
        this.productionDay = productionDay;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public Float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Float screenSize) {
        this.screenSize = screenSize;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Integer getHhd() {
        return hhd;
    }

    public void setHhd(Integer hhd) {
        this.hhd = hhd;
    }

    public Integer getSsd() {
        return ssd;
    }

    public void setSsd(Integer ssd) {
        this.ssd = ssd;
    }

    public Integer getWattage() {
        return wattage;
    }

    public void setWattage(Integer wattage) {
        this.wattage = wattage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getDiscriminator() {
        return Discriminator;
    }

    public void setDiscriminator(String discriminator) {
        Discriminator = discriminator;
    }
}
