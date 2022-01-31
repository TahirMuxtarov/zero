package com.example.onetomany.service;

import com.example.onetomany.entity.Actor;
//import com.speedment.jpastreamer.application.JPAStreamer;
import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.ActorRepository;
import com.example.onetomany.repository.MovieRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //@Transactional
    public void newMovieExistingAuthor(Long id, Movie movie) throws InterruptedException {
        Actor actor = actorRepository.getByActorId(id);
        System.err.println(actor);
        System.err.println(actor.getMovies());


        /*Thread.sleep(100);
        System.err.println("checkpoint 1");
        Thread.sleep(100);
        Actor actor = actorRepository.findById(id).get();

        movieRepository.save(movie);
        actorRepository.save(actor);
        Thread.sleep(100);
        System.err.println("checkpoint 2");
        Thread.sleep(100);
        System.out.println(actor);///////////////////////////////////
        Thread.sleep(100);
        System.err.println("checkpoint 3");
        Thread.sleep(100);
        System.out.println(movie);
        Thread.sleep(100);
        System.err.println("checkpoint 4");
        //actor.addMovie(movie);
        //movie.setActors(Set.of(actor));
        //movieRepository.save(movie);
        //System.out.println(movie);*/
 /*       Actor actor = actorRepository.findById(id).get();
        System.err.println(movie);
        actor.getMovies().add(movie);
        //ctorRepository.save(actor);
        movieRepository.save(movie);*/



    }
    //@Transactional
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }
    //@Transactional
    public void saveNewMoviesExistingActor(Long id, Set<Movie> movies) {
        for(Movie m:movies){
            System.err.println(m.getAuthor());
        }
        Actor actor = actorRepository.findById(id).get();
        actor.setMovies(movies);
        actorRepository.save(actor);
    }

    public void testx(Long id, Long idx) {
       /* Actor actor = actorRepository.getByActorId(id);
        Movie movie = movieRepository.getByMovieId(idx);
        actor.setMovies(Set.of(movie));
        movieRepository.save(movie);
        //movie.setActors(Set.of(actor));
        //actorRepository.save(actor);*/
        Actor actor = new Actor("Ana De Armas",34);
        Movie movie = new Movie("Knives Out","knvs234234");
        Movie movie1=new Movie("Blade Runner 2049","bldr21323");
        Author author = new Author(50,"Dennis Villenuve","science-fiction");
        movie1.setAuthor(author);
        actor.setMovies(Set.of(movie,movie1));
        actorRepository.save(actor);
    }
}
