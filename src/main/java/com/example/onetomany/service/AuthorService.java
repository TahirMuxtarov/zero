package com.example.onetomany.service;

import com.example.onetomany.dto.AuthorDto;
import com.example.onetomany.dto.MovieDto;
import com.example.onetomany.entity.Actor;
import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.ActorRepository;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.*;

/*@Service
@RequiredArgsConstructor
@Slf4j*/
@Slf4j
@Service
public class AuthorService {

    //@PersistenceContext
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private  AuthorRepository authorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ActorRepository actorRepository;

    public List<Movie> getAuthorsMoviesById(Long id) {
       return authorRepository.getMoviesByAuthoId(id);
    }

    /*public Author save(Author author) {

        log.info("inside save");
        List<Movie>movies = author.getMovies();
        for(Movie m: movies){
            System.out.println(m+" movie");
            m.setAuthor(author);
            movieRepository.save(m);
        }
        return authorRepository.save(author);
    }*/

    public List<Movie> insertNewMoviesToExistingAuthor(List<Movie> movies,Long id) {
        Author author = authorRepository.getById(id);
        log.info("insertNewMoviesToExistingAuthor");
        for(Movie m:movies){
            System.out.println(m);
            for(Actor a:m.getActors()){
                System.out.println(a);
                actorRepository.save(a);

            }
            m.setAuthor(author);
            movieRepository.save(m);
        }
        return movies;
    }

    public Author createNewAuthorNewMovieNewActor(Author author) {
        System.err.println(author);
        System.err.println(author.getMovies());
        System.err.println("createNewAuthorNewMovieNewActor int service");
        return authorRepository.save(author);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE,readOnly = true,rollbackFor = Exception.class)

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
    @Transactional()
    public void testTransaction(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Author author = new Author(55,"Denis Villenuve","science-fiction");

        transaction.begin();
        entityManager.persist(author);
        transaction.commit();
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*Movie movie = new Movie("Dune","dn2342");
        Movie movie1 = new Movie("Blade Runner 2049","bldrn234");
        *//*author.setMovies(List.of(movie,movie1));
        authorRepository.save(author);*//*
        movie.setAuthor(author);
        movie1.setAuthor(author);

        movieRepository.save(movie);
        movieRepository.save(movie1);
        throw new RuntimeException();
        //movie1.setAuthor(author);*/
    }

    public void testTransaction2() {
    }


/*



    private Author mapToAuthor(AuthorDto authorDto){
        Author author = Author.builder()
                .age(authorDto.getAge())
                .genre(authorDto.getGenre())
                .name(authorDto.getName())
                .books(authorDto.getBooks()).build();
        return author;
    }
    private AuthorDto mapToAuthorDto(Author author){
        AuthorDto authorDto = AuthorDto.builder()
                .age(author.getAge())
                .genre(author.getGenre())
                .name(author.getName())
                .books(author.getBooks())
                .build();
        return authorDto;
    }

    private Movie mapToBook(MovieDto bookDto){
        Movie book = modelMapper.map(bookDto, Movie.class);
        return book;
    }
    private MovieDto mapToBookDto(Movie book){
        MovieDto bookDto = modelMapper.map(book, MovieDto.class);
        return bookDto;
    }
    private AuthorDto mapToDto(Author author){
        AuthorDto authorDto = modelMapper.map(author,AuthorDto.class);
        return authorDto;
    }
    private Author mapToEntity(AuthorDto authorDto){
        Author author = modelMapper.map(authorDto,Author.class);
        return author;
    }

    public Optional<Author> getAuthorById(Long id) {
      return  authorRepository.getAuthorById(id);

        //return  entityManager.find(Author.class,id);
        //return authorRepository.findById(id);
    }

    public List<Author> ageIsLessThan(Integer age){
       return authorRepository.findByAgeLessThan(age);
    }
*/



}
