package com.test.controller;

import com.test.entity.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

//    private Book book;

    @RequestMapping("/book")
    private Book testBookValue() {
        Book book = new Book();
        return book;
    }
}
