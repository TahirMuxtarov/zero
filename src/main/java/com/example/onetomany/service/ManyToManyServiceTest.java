package com.example.onetomany.service;

import com.example.onetomany.entity.Actor;
import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.ActorRepository;
import com.example.onetomany.repository.MovieRepository;
import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ManyToManyServiceTest {

    private final ActorRepository actorRepository;

    private final MovieRepository movieRepository;

    public void test(){
        ////// mixed one to many, many to many
        //Author author = new Author(76,"Stiven Spilberg","drama-thriller");
        System.err.println("Point 112");
        Actor actor = new Actor("Matt Damon",42);
        System.err.println("Point 113");
        Movie movie = new Movie("Saving private Ryan","spr234234");
       // movie.setAuthor(author);
        System.err.println("Point 114");
        //actor.setMovies(Set.of(movie));
        System.err.println("Point 115");
        //actorRepository.save(actor);
        movie.setActors(Set.of(actor));
        movieRepository.save(movie);

    }
    public void test2(Long id){
        /*Actor actor = actorRepository.getByActorId(id);
        System.err.println(actor);
        for(Movie m : actor.getMovies()){
            System.err.println(m);
            movieRepository.delete(m);
        }*/
        actorRepository.deleteById(id);
    }

}
