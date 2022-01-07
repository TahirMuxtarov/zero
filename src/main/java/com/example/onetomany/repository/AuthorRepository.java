package com.example.onetomany.repository;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Book;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {


    @Query("select a from Author a JOIN FETCH a.books where a.id=?1")
    Optional<Author> getAuthorById(Long id);


    /*@Query("select a from Author a where a.age < ?1")
    List<Author> findByAgeLessThan(Integer age);*/

    List<Author>findByAgeLessThan(Integer age);

    //Book removeBookOfExistingAuthor(Long id, String name);


}
