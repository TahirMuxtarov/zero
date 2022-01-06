package com.example.onetomany.dto;

import com.example.onetomany.entity.Author;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {


    private Long id;

    private String title;

    private String isbn;


    private Author author;
}
