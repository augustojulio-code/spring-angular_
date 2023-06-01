package com.julio.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.bookstore.domain.Book;
import com.julio.bookstore.domain.Category;
import com.julio.bookstore.repositories.BookRepository;
import com.julio.bookstore.repositories.CategoryRespository;

@Service
public class DBService {

    @Autowired
    private CategoryRespository categoryRespository;
    @Autowired
    private BookRepository bookRepository;

    public void instanceBooksCat() {

        Category cat1 = new Category(null, "Informática", "Livros de TI");
        Category cat2 = new Category(null, "Ficcção Científica", "Ficcção científica");
        Category cat3 = new Category(null, "Biografias", "Livros de Biografias");

        Book l1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
        Book l2 = new Book(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
        Book l3 = new Book(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
        Book l4 = new Book(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
        Book l5 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);

        cat1.getBook().addAll(Arrays.asList(l1, l2));
        cat2.getBook().addAll(Arrays.asList(l3, l4, l5));

        this.categoryRespository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.bookRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

    }

}
