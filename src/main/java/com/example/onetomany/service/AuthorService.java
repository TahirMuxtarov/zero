package com.example.onetomany.service;

import com.example.onetomany.dto.AuthorDto;
import com.example.onetomany.dto.BookDto;
import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Book;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.repository.BookRepository;
import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/*@Service
@RequiredArgsConstructor
@Slf4j*/
@Service
public class AuthorService {

    @PersistenceContext

    private EntityManager entityManager;

    @Autowired
    private  AuthorRepository authorRepository;

    @Autowired
    private  BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;




    private Author mapToAuthor(AuthorDto authorDto){
        Author author = Author.builder()
                .age(authorDto.getAge())
                .genre(authorDto.getGenre())
                .name(authorDto.getName())
                .books(authorDto.getBooks()).build();
        return author;
    }
    private AuthorDto mapToAuthorDto(Author author){
        AuthorDto authorDto = AuthorDto.builder()
                .age(author.getAge())
                .genre(author.getGenre())
                .name(author.getName())
                .books(author.getBooks())
                .build();
        return authorDto;
    }

    private Book mapToBook(BookDto bookDto){
        Book book = modelMapper.map(bookDto,Book.class);
        return book;
    }
    private BookDto mapToBookDto(Book book){
        BookDto bookDto = modelMapper.map(book,BookDto.class);
        return bookDto;
    }
    private AuthorDto mapToDto(Author author){
        AuthorDto authorDto = modelMapper.map(author,AuthorDto.class);
        return authorDto;
    }
    private Author mapToEntity(AuthorDto authorDto){
        Author author = modelMapper.map(authorDto,Author.class);
        return author;
    }

    public Author getAuthorById(Long id) {
        authorRepository.findById(id);

        return  entityManager.find(Author.class,id);
        //return authorRepository.findById(id);
    }

    public List<Author> ageIsLessThan(Integer age){
       return authorRepository.findByAgeLessThan(age);
    }
}
