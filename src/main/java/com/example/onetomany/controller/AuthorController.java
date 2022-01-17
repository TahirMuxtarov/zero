package com.example.onetomany.controller;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author/")
@RequiredArgsConstructor
public class AuthorController {


    private final AuthorService authorService;

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

}
