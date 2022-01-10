package com.example.onetomany.repositoryImpl;

import com.example.onetomany.entity.Actor;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.MovieRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
//@Repository
public class MovieRepositoryCustomImpl implements MovieRepositoryCustom {

    @Autowired
    private EntityManager entityManager;
    @Override
    public Movie findMoviesByTitle( String title) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
        Root<Movie> movie = criteriaQuery.from(Movie.class);
        //Predicate isbnPredicate = criteriaBuilder.equal(movie.get("isbn"),isbn);
        Predicate titlePredicate = criteriaBuilder.equal(movie.get("title"),title);
        criteriaQuery.where(titlePredicate);
        TypedQuery<Movie> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public List<Movie> findMoviesByIsbnAndTitle( String title,String isbn) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
        Root<Movie> movie = criteriaQuery.from(Movie.class);
        Predicate isbnPredicate = criteriaBuilder.equal(movie.get("isbn"),isbn);
        Predicate titlePredicate = criteriaBuilder.equal(movie.get("title"),title);
        criteriaQuery.where(titlePredicate,isbnPredicate);
        TypedQuery<Movie> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<Movie> findMoviesWithActors(String... name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
        Root<Actor> movie = criteriaQuery.from(Actor.class);
        Predicate name1Predicate = criteriaBuilder.equal(movie.get("name"),name);
        Predicate name2Predicate = criteriaBuilder.equal(movie.get("name"),name);
        criteriaQuery.where(name1Predicate,name2Predicate);
        TypedQuery<Movie> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
