package com.example.sbtickets.controller;

import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.Book;
import com.example.sbtickets.entity.Driver;
import com.example.sbtickets.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @RequestMapping(value = UrlConst.GET_BOOK, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> getBook() {
        WrapperResponse response = new WrapperResponse();
        List<Book> result = new ArrayList<>();
        try {
            result = bookService.getBook();
            response.setBody(result);
            response.setStatus(HttpStatus.OK.value());
        }
        catch (Exception ex){
            response.setMsg("Not found");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
//ygjhhlhkhgjh
}
