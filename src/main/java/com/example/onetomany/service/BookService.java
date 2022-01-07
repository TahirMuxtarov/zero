package com.example.onetomany.service;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Book;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book>findDistinctByName(String name){
        return bookRepository.findDistinctByTitle(name);
    }

    public List<String> distinctByTitle(){
        return bookRepository.distinctByTitle();
    }

    public Book removeBookExistingAuthor(Long id,String title){
        //Author a = authorRepository.getAuthorById(id);

        List<Book> list= bookRepository.getBooksByAuthorId(id);


        for(Book b :list){
            bookRepository.delete(b);
        }

        return null;

    }

    public List<Book> returnBooks(){
        return bookRepository.returnBook();
    }

}
