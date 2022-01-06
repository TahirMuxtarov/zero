package com.example.onetomany.controller;

import com.example.onetomany.entity.Book;
import com.example.onetomany.repository.BookRepository;
import com.example.onetomany.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book/")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("distinct/{name}")
    public List<Book> getAllDistinct(@PathVariable String name){
        return bookService.findDistinctByName(name);
    }
    @GetMapping("distinctX")
    public List<String> distinctByTitle(){
        return bookService.distinctByTitle();
    }
}
