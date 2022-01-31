package com.example.onetomany.service;

import com.example.onetomany.dto.AuthorDto;
import com.example.onetomany.entity.Actor;
import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.ActorRepository;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ActorRepository actorRepository;

    public void insertNewMovies(Long id,List<Movie>list){
        Author a = authorRepository.getById(id);
        for(Movie m : list){
            m.setAuthor(a);
            movieRepository.save(m);
        }
    }

    //@Transactional
    public  void newActorsToExistingMovie(Long id,List<Actor>actors) {

        Set<Actor> set = movieRepository.getByMovieId(id).getActors();

        for (Actor ac : actors) {
            set.add(ac);
        }
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void save(Movie movie) {

       /* for (Movie m : movies){
            m.setAuthor(m.getAuthor());
            movieRepository.save(m);
        }*/
        System.out.print(movie.getAuthor() +" actor is");
        movie.setAuthor(movie.getAuthor());
        movieRepository.save(movie);


    }

    public List<Movie> newMovies(List<Movie> movies) {
        for(Movie m:movies){
            movieRepository.save(m);
        }
        return movies;

    }

    public AuthorDto getAuthorByMovieId(Long id) {
        Movie movie = movieRepository.getByMovieId(id);
        System.err.println(movie);
        Author author = movie.getAuthor();
        AuthorDto authorDto = AuthorDto.builder()
                        .age(author.getAge())
                                .name(author.getName())
                                        .genre(author.getGenre())
                                                .build();
        System.err.println(author);
        return authorDto;
    }
 /*   @Transactional
    public void insertNewBooksToExistingAuthor(Long id,Set<Book> books){
        Author author = authorRepository.getAuthorById(id);
        Set<Book> set = author.getBooks();
        for(Book b:books){
            set.add(b);
        }
    }*/

    }

