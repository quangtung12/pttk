package com.example.sbtickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="PulisherID")
    @JsonIgnoreProperties(value = {
            "referenceList",
            "handler",
            "hibernateLazyInitializer"
    }, allowSetters = true)
    private Publisher publisher;
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<ItemBook> itemBooks;

    public Book() {
    }

    public Book(Integer id, String title, String language, Date publicationDate, Integer numberOfPage, String isbn) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numberOfPage = numberOfPage;
        this.isbn = isbn;
    }

    public Book(String title, String language, Date publicationDate, Integer numberOfPage, String isbn, String image, Publisher publisher) {
        this.title = title;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numberOfPage = numberOfPage;
        this.isbn = isbn;
        this.image = image;
        this.publisher = publisher;
    }

    public Book(Integer id, String title, String language, Date publicationDate, Integer numberOfPage, String isbn, String image, Publisher publisher) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numberOfPage = numberOfPage;
        this.isbn = isbn;
        this.image = image;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
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

//    public Publisher getPublisher() {
//        return publisher;
//    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
//    public ArrayList<ItemBook> getItemBooks() {
//        return itemBooks;
//    }
//
//    public void setItemBooks(ArrayList<ItemBook> itemBooks) {
//        this.itemBooks = itemBooks;
//    }
}
