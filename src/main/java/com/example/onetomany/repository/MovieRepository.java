package com.example.onetomany.repository;

import com.example.onetomany.entity.Actor;
import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>, JpaSpecificationExecutor,MovieRepositoryCustom {


    @Query(value = "select * from movie  where author_id =?1",nativeQuery = true)
    List<Movie>getMoviesByAuthorid(Long id);

    @Query("select m from Movie m where m.author.id = :id")
    List<Movie>moviesByAuthorId(Long id);


    @Query("select m from Movie m where m.title =?1")
    Movie getByTitle(String title);

    @Query("select m from Movie m where m.id =?1")
    Movie getByMovieId(Long id);

    /*@Query("select a from Movie a where id=?1")
    Author getAuthorByMovieId(Long id);*/

    //List<Actor> newActorsToExistingMovie(Long id, List<Actor> actors);
    List<Movie> findByTitleContaining(String text);
}
