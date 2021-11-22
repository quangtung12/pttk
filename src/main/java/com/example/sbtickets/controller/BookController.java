package com.example.sbtickets.controller;

import com.example.sbtickets.bean.BookBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.Book;
import com.example.sbtickets.entity.Publisher;
import com.example.sbtickets.service.BookService;
import com.example.sbtickets.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    PublisherService publisherService;
    @RequestMapping(value = UrlConst.GET_BOOKS, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> getBook() {
        WrapperResponse response = new WrapperResponse();
        List<Book> result = new ArrayList<>();
        try {
            result = bookService.getBooks();
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
    @GetMapping(UrlConst.GET_BOOK_BY_ID)
    public ResponseEntity<WrapperResponse> getBookById(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
       Book result = null;
        try {
            result = bookService.getBookById(id);
            if(result == null){
                response.setMsg("Can't not find book with id=" + id);
                response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
                return new ResponseEntity<WrapperResponse>(response, HttpStatus.EXPECTATION_FAILED);
            }
            response.setBody(result);
            response.setStatus(HttpStatus.OK.value());
        }catch (
                Exception ex
        ){
            response.setMsg("Not found");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
    @PostMapping(UrlConst.CREATE_BOOK)
    public ResponseEntity<WrapperResponse>  createBook(@RequestBody BookBean book){
        WrapperResponse response = new WrapperResponse();
        try {
            int publisherId = book.getPublisherId();
        Publisher publisher = publisherService.getPublisherById(publisherId);
          if(publisher != null){
              Book addedBook = new Book(book.getTitle(),book.getLanguage(), book.getPublicationDate(),
                      book.getNumberOfPage(), book.getIsbn(), book.getImage(), publisher);
              bookService.createBook(addedBook);
              response.setMsg("Add Book Successfully");
              response.setStatus(HttpStatus.OK.value());
          }

        }catch (
                Exception ex
        ){
            ex.printStackTrace();
            response.setMsg("Add Book Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
    @PutMapping(UrlConst.UPDATE_BOOK)
    public ResponseEntity<WrapperResponse> updateBook(@PathVariable (value =  "id") int id, @RequestBody BookBean book) throws Exception {
        WrapperResponse response = new WrapperResponse();
        try {
            Book itemBook = bookService.getBookById(id);
            int publisherId = book.getPublisherId();
            Publisher publisher = publisherService.getPublisherById(publisherId);
            Book editedBook = new Book(id, book.getTitle(),book.getLanguage(), book.getPublicationDate(),
                    book.getNumberOfPage(), book.getIsbn(), book.getImage(), publisher);
            bookService.updateBook(editedBook);
            response.setMsg("Update Book Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Add Book Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
    @DeleteMapping(UrlConst.DELETE_BOOK)
    public ResponseEntity<WrapperResponse> deleteBook(@PathVariable(value = "id") int id){
        WrapperResponse response = new WrapperResponse();
        try {
            bookService.deleteBook(id);
            response.setMsg("Delete Book Successfully");
            response.setStatus(HttpStatus.OK.value());

        }catch (Exception ex){
            response.setMsg("Delete Book Failed");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }






}
