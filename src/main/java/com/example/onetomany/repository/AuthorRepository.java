package com.example.onetomany.repository;

import com.example.onetomany.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {


/*
    @Query("select a from Author a JOIN FETCH a.books where a.id=?1")
    Optional<Author> getAuthorById(Long id);


    */
/*@Query("select a from Author a where a.age < ?1")
    List<Author> findByAgeLessThan(Integer age);*//*


    List<Author>findByAgeLessThan(Integer age);

    //Book removeBookOfExistingAuthor(Long id, String name);

    */
/*@Query(value = "select * from author a where id=50",nativeQuery = true)
    Author getAuthorByIdLazy(Long id);*/

    @Query("select a from Author a where a.id =?1")
    Author findAuthorById(Long id);

    @Query("select a from Author a where a.name like %?1%")
    Author fetchByNamelike(String name);



}
