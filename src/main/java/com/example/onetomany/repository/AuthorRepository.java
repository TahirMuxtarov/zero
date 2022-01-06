package com.example.onetomany.repository;

import com.example.onetomany.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {


    @Query("select a from Author a where a.id=?1")
    Author getAuthorById(Long id);

}
