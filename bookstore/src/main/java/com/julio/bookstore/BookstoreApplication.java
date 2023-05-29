package com.julio.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.julio.bookstore.domain.Book;
import com.julio.bookstore.domain.Category;
import com.julio.bookstore.repositories.BookRepository;
import com.julio.bookstore.repositories.CategoryRespository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoryRespository respository;
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "IT", "it Book");

		Book book1 = new Book(null, "Java ", "robert martin", "lorem ipsum", cat1);

		cat1.getLisBook().addAll(Arrays.asList(book1));

		this.respository.saveAll(Arrays.asList(cat1));
		this.bookRepository.saveAll(Arrays.asList(book1));
	}

}
