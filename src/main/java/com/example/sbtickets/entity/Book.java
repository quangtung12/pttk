package com.example.sbtickets.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PulisherID")
    private Integer publisherID;
    @Column(name = "Title")
    private String title;
    @Column(name = "Language")
    private String language;
    @Column(name = "Publication_date")
    private Date publicationDate;
    @Column(name = "Number_of_page")
    private Integer numberOfPage;
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "Image")
    private String image;

    public Book() {
    }

    public Book(Integer id, Integer publisherID, String title, String language, Date publicationDate, Integer numberOfPage, String isbn) {
        this.id = id;
        this.publisherID = publisherID;
        this.title = title;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numberOfPage = numberOfPage;
        this.isbn = isbn;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPublisherID() {
        return publisherID;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Integer getNumberOfPage() {
        return numberOfPage;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPublisherID(Integer publisherID) {
        this.publisherID = publisherID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setNumberOfPage(Integer numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
