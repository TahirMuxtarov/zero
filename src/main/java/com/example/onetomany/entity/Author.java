package com.example.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonIgnoreProperties
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    private String name;

    private String genre;
    @JsonIgnore
    @OneToMany(mappedBy = "author",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book> books=new ArrayList<>();


    public Author addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
        return this;
    }
    public Author removeBook(Book book) {
        book.setAuthor(null);
        this.books.remove(book);
        return this;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", books=" + books +
                '}';
    }

  /*  public Author setId(Long id) {
        this.id = id;
        return this;
    }
    public Author setName(String name) {
        this.name = name;
        return this;
    }
    public Author setGenre(String genre) {
        this.genre = genre;
        return this;
    }
    public Author setAge(int age) {
        this.age = age;
        return this;
    }
    public Author setBooks(List<Book> books) {
        this.books = books;
        return this;
    }*/

}
