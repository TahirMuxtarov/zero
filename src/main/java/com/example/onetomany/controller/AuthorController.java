package com.example.onetomany.controller;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.service.AuthorService;
import com.example.onetomany.service.EntityServices;
import com.example.onetomany.service.MovieService;
import com.example.onetomany.service.OneToManyTest;
import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author/")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;

    private final OneToManyTest oneToManyTest;


    private final AuthorService authorService;

    private final MovieService movieService;

    private final EntityServices entityServices;

    /*@GetMapping("{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }
    @GetMapping("agex/{age}")
    public List<Author> ageLessThan(@PathVariable Integer age){
        return authorService.ageIsLessThan(age);
    }
*/

    @GetMapping("{id}")
    public List<Movie> getAuthorMovies(@PathVariable Long id){
        return authorService.getAuthorsMoviesById(id);
    }

    @PostMapping
    public Author newAuthorWithMovies(@RequestBody Author author){
       return authorService.save(author);

    }
    @PostMapping("{id}")
    public List<Movie>insertNewMovieExistingAuthor(@RequestBody List<Movie> movies,@PathVariable Long id){
        return authorService.insertNewMoviesToExistingAuthor(movies,id);
    }
    @PostMapping("newAuthorNewMovieNewActor")
    public Author createNewAuthorNewMovieNewActor(@RequestBody Author author){
        System.err.println("createNewAuthorNewMovieNewActor int controller");
        return authorService.createNewAuthorNewMovieNewActor(author);
    }
    @PostMapping("newAuthor")
    public Author createNewAuthor(@RequestBody Author author){
        return  authorService.save(author);
    }
    @PostMapping("oneToManyTest/{id}")
    public void test(@PathVariable Long id,@RequestBody List<Movie>movies){
        oneToManyTest.test(id,movies);
    }

    @PostMapping("newMovies")
    public List<Movie>newMovies(@RequestBody List<Movie>movies){
        return movieService.newMovies(movies);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorRepository.deleteById(id);
    }
    @GetMapping("n")
    public List<Author> getAllAuthorAndMovies(){

        return authorService.findAll();
    }

    @PostMapping("testEntity")
    public void testEntity()throws IOException {
        entityServices.testEntity();
    }
    @GetMapping("nproblem/{containing}")
    public List<Author> test(@PathVariable String containing){

     List<Author> list=   authorRepository.findByNameContaining(containing);

     for(Author a:list){
         System.err.println(a);
     }

     return list;
    }

    @GetMapping("allAuthors")
    public void getAllAuthors(){
        authorRepository.findAll().forEach(System.out::println);
    }
    @GetMapping("ageGreaterThan/{age}")
    public List<Author>ageGreaterThan(@PathVariable Integer age){
        List<Author> byAgeGreaterThanEqual = authorRepository.findByAgeGreaterThanEqual(age);
        for(Author a:byAgeGreaterThanEqual){
            System.out.println(a.getMovies());
        }
        return byAgeGreaterThanEqual;
    }
    @PostMapping("testTransaction")
    public void testTransaction(){
        authorService.testTransaction();
    }
    @PostMapping("testTransaction2")
    public void testTransaction2(){
        authorService.testTransaction2();
    }

}
