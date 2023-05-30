package com.julio.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.bookstore.domain.Book;
import com.julio.bookstore.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }
}
