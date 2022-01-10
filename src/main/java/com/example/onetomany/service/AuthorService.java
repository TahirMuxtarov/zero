package com.example.onetomany.service;

import com.example.onetomany.dto.AuthorDto;
import com.example.onetomany.dto.MovieDto;
import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/*@Service
@RequiredArgsConstructor
@Slf4j*/
@Service
public class AuthorService {

    @PersistenceContext

    private EntityManager entityManager;

    @Autowired
    private  AuthorRepository authorRepository;

    @Autowired
    private MovieRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

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
