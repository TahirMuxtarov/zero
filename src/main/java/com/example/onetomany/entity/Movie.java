package com.example.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@NamedNativeQuery(name="Book.returnBook",query = "select * from book b where b.title like '%ow%'",resultClass = Book.class)
@JsonIgnoreProperties

public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author;


    @JsonIgnore
    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors = new HashSet<>();


    public Movie(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Movie(String title, String isbn, Set<Actor> actors) {
        this.title = title;
        this.isbn = isbn;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
