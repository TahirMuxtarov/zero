package com.example.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonIgnoreProperties

public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY
            ,cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author;

    /*public Book setId(Long id) {
        this.id = id;
        return this;
    }
    public Book setTitle(String title) {
        this.title = title;
        return this;
    }
    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }
    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }*/

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
}
