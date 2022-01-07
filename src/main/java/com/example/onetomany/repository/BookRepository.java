package com.example.onetomany.repository;

import com.example.onetomany.entity.Book;
import liquibase.pro.packaged.A;
import liquibase.pro.packaged.Q;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "select * from book b where b.author_id=?1",nativeQuery = true)
    List<Book> getBooksByAuthorId(Long id);


    @Query("select b from Book b ")
    List<Book> getAllBooks();

    List<Book>findDistinctByTitle(String name);

    @Query(value = "select DISTINCT title from book",nativeQuery = true)
    //@Query(value = "select distinct title from book ;",nativeQuery = true)
    List<String>distinctByTitle();


   /// @Query(value = "select * from book  where title like 'Re%'",nativeQuery = true)
    List<Book> returnBook();
}
