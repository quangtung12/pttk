package com.example.sbtickets.bean;

import com.example.sbtickets.entity.Publisher;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Getter
@Setter
public class BookBean {
    private String title;
    private String language;
    private Date publicationDate;
    private Integer numberOfPage;
    private String isbn;
    private String image;
    private int publisherId;
}
