package com.example.onetomany.service;

import com.example.onetomany.entity.Actor;
//import com.speedment.jpastreamer.application.JPAStreamer;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.ActorRepository;
import com.example.onetomany.repository.MovieRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Actor>getOlderThan50(){
        return actorRepository.olderThan50();
    }


    public Actor addNewActor(Actor actor) {
   /* for(Movie m:actor.getMovies()){
        Set<Actor> actors = new HashSet<>();
        actors.add(actor);
        m.setActors(actors);
        movieRepository.save(m);

    }*/
        System.out.print(actor.getMovies());
        return actorRepository.save(actor);
    }
}
