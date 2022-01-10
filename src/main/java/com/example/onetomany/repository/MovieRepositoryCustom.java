package com.example.onetomany.repository;

import com.example.onetomany.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepositoryCustom {
    public Movie findMoviesByTitle(String title);
    public List<Movie> findMoviesByIsbnAndTitle(String title,String isbn);


    List<Movie> findMoviesWithActors(String... name);
}
