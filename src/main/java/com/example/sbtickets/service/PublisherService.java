package com.example.sbtickets.service;

import com.example.sbtickets.entity.Book;
import com.example.sbtickets.entity.Publisher;
import com.example.sbtickets.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PublisherService implements PublisherImplement{
    @Autowired
    PublisherRepository publisherRepository;
    @Override
    public Publisher getPublisherById(int id) {

        try {
            Publisher   res= publisherRepository.findById(id).orElseThrow(() ->new Exception("Not found " +
                    "publisher"));
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }
}
