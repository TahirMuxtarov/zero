package com.example.onetomany.repository;

import com.example.onetomany.entity.Book;
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
}
