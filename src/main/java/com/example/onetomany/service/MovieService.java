package com.example.onetomany.service;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthorRepository authorRepository;



    public void insertNewMovies(Long id,List<Movie>list){
        Author a = authorRepository.getById(id);
        for(Movie m : list){
            m.setAuthor(a);
            movieRepository.save(m);
        }
    }
}
