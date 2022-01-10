package com.example.onetomany.controller;

import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.repository.MovieRepository;
import com.example.onetomany.repositoryImpl.MovieRepositoryCustomImpl;
import com.example.onetomany.service.AuthorService;
import com.example.onetomany.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie/")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private MovieRepositoryCustomImpl movieRepositoryCustom;

    @PostMapping("/{id}")
    public void addNewMovies(@PathVariable Long id,@RequestBody List<Movie> movie){
         movieService.insertNewMovies(id,movie);
    }

    @GetMapping("/{id}")
    public List<Movie>moviesByAuthorId(@PathVariable Long id){
        return authorRepository.getById(id).getMovies();
    }
    @GetMapping("id/{id}")
    public List<Movie>getMoviesByAuthorId2(@PathVariable Long id){
        return movieRepository.getMoviesByAuthorid(id);
    }
    @GetMapping("t/{title}")
    public Movie getMoviesByTitle(@PathVariable String title){
        return movieRepositoryCustom.findMoviesByTitle(title);
    }
    @GetMapping("title/{title}")
    public Movie getMovieByTitle(@PathVariable String title){
        return movieRepository.findMoviesByTitle(title);
    }
    @GetMapping("title/{title}/{isbn}")
    public List<Movie> findMoviesByIsbnAndTitle(@PathVariable String title,@PathVariable String isbn){
        return movieRepository.findMoviesByIsbnAndTitle(title,isbn);
    }
    @GetMapping("actors/{name1}/{name2}")
    public List<Movie>getMoviesByActors(@PathVariable String name1,@PathVariable String name2){
        return movieRepository.findMoviesWithActors(name1,name2);
    }
}
