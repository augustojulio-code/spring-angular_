package com.julio.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.julio.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT obj FROM Book as obj WHERE obj.category.id = :id_cat ORDER BY title")
    List<Book> findAllByCategory(@Param(value = "id_cat") Long id_cat);

}
