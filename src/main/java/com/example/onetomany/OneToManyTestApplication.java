package com.example.onetomany;

import com.example.onetomany.entity.Author;
import com.example.onetomany.repository.AuthorRepository;
import com.example.onetomany.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor

public class OneToManyTestApplication implements CommandLineRunner {


	/*@Autowired

	private AuthorRepository authorRepository;

	@Autowired

	private MovieRepository movieRepository;

*/
	public static void main(String[] args) {
		SpringApplication.run(OneToManyTestApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	//List<Author> authors=authorRepository.findAll();
	//System.err.println(list);
	//	List<Movie> movies = movieRepository.findAll();
	//	System.err.println(movies);
		//Author a = authorRepository.getById(1l);
		//Optional<Author> a1 = authorRepository.findById(1l);
		//Author a = authorRepository.fetchByNamelike("olan");

		//a1.get().addMovie(new Movie("Dark knight rises","dkr23424"));
		//a.addMovie(new Movie("Dark knight rises","dkr23424"));
		//System.err.println(a);
		//List<Movie> list=movieRepository.getAuthorMoviesById(1l);

		//a.addMovie(new Movie("dark knight rises","sf3ffsf"));
		//System.err.println(a.getMovies());


	}
}
