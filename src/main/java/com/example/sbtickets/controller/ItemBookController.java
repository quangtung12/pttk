//package com.example.sbtickets.controller;
//
//import com.example.sbtickets.common.UrlConst;
//import com.example.sbtickets.entity.ItemBook;
//import com.example.sbtickets.service.ElectronicService;
//import com.example.sbtickets.service.ItemBookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class ItemBookController {
//    @Autowired
//    ItemBookService itemBookService;
//    @GetMapping(UrlConst.GET_ITEM_BOOKS)
//    public List<ItemBook> getItemBooks(){
//        return itemBookService.getItemBooks();
//    }
//
//
//}
