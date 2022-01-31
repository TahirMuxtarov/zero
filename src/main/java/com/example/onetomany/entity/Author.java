package com.example.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//@NamedNativeQuery(name = "getAllBook",query = "select * from table book")
//@JsonIgnoreProperties
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    private String name;

    private String genre;
    @JsonIgnore
    @OneToMany(mappedBy = "author",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Movie> movies=new ArrayList<>();

   /* public Author(Integer age, String name, String genre) {
        this.age = age;
        this.name = name;
        this.genre = genre;
    }*/

    public Author addMovie(Movie movie) {
        this.movies.add(movie);
        movie.setAuthor(this);
        return this;
    }
    public Author removeMovie(Movie movie) {
        movie.setAuthor(null);
        this.movies.remove(movie);
        return this;
    }

    public Author(Integer age, String name, String genre, List<Movie> movies) {
        this.age = age;
        this.name = name;
        this.genre = genre;
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Author{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", movies=" + movies +
                '}';
    }

    public Author(Integer age, String name, String genre) {
        this.age = age;
        this.name = name;
        this.genre = genre;
    }
}
