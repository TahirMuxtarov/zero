package com.example.onetomany.service;

import com.example.onetomany.entity.Book;
import com.example.onetomany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
