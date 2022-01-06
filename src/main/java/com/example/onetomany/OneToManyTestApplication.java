package com.example.onetomany;

import com.example.onetomany.entity.Author;
import com.example.onetomany.service.AuthorService;
import com.example.onetomany.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@RequiredArgsConstructor

public class OneToManyTestApplication implements CommandLineRunner {




	public static void main(String[] args) {
		SpringApplication.run(OneToManyTestApplication.class, args);
	}


	private final BookService bookService;

	private final AuthorService authorService;

	@Override
	public void run(String... args) throws Exception {




	}
}
