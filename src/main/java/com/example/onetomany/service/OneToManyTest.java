package com.example.onetomany.service;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.repository.MovieRepository;
import liquibase.pro.packaged.M;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneToManyTest {


    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void test(Long id,List<Movie>movies){
        /*Author author = new Author(71,"Stanley Kubrick","mixed");
        Movie movie = new Movie("Shining","sh2324g");
        *//*author.setMovies(List.of(movie));
        authorRepository.save(author);*//*
        movie.setAuthor(author);
        movieRepository.save(movie);*/
        /*System.err.println(author.getMovies());
        authorRepository.save(author);*/
      /*  Author authorx = new Author(71,"Stanley Kubrick","mixed");
        Movie movie = new Movie("Shining","sh2324g");
        Movie movie2 = new Movie("Space Odyssey 2001","spo20v");
        //authorx.setMovies(List.of(movie,movie2));
        //authorRepository.save(authorx);
       // movieRepository.save(movie);
       // movieRepository.save(movie2);
        movie2.setAuthor(authorx);
        movie.setAuthor(authorx);
        movieRepository.save(movie);
        movieRepository.save(movie2);*/
        //System.out.println(author);
        Author author = authorRepository.findById(id).get();
        for(Movie m:movies){
            m.setAuthor(author);
            movieRepository.save(m);
        }
    }


}
