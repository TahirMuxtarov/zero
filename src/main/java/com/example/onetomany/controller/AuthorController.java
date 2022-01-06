package com.example.onetomany.controller;

import com.example.onetomany.dto.AuthorDto;
import com.example.onetomany.dto.BookDto;
import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Book;
import com.example.onetomany.service.AuthorService;
import com.example.onetomany.serviceImpl.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/author/")
@RequiredArgsConstructor
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

}
