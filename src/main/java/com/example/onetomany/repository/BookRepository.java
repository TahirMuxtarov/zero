package com.example.onetomany.repository;

import com.example.onetomany.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "select * from book b where b.author_id=?1",nativeQuery = true)
    Set<Book> getBooksByAuthorId(Long id);
}
