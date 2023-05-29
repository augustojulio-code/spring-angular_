package com.julio.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julio.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
