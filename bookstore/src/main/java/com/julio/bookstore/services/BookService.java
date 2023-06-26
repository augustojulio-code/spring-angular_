package com.julio.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.bookstore.domain.Book;
import com.julio.bookstore.domain.Category;
import com.julio.bookstore.repositories.BookRepository;
import com.julio.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryService categoryService;

    public List<Book> findAll(Long id_cat) {

        categoryService.findById(id_cat);

        return repository.findAllByCategory(id_cat);
    }

    public Book findById(Long id) {
        Optional<Book> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id));

    }

    public Book update(Long id, Book obj) {
        Book newObj = findById(id);
        updateData(newObj, obj);

        return repository.save(newObj);
    }

    private void updateData(Book newObj, Book obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setAuthor(obj.getAuthor());
        newObj.setText(obj.getText());

    }

    public Book create(Long id_cat, Book obj) {
        obj.setId(null);
        Category cat = categoryService.findById(id_cat);
        obj.setCategory(cat);

        return repository.save(obj);
    }

    public List<Book> findAll() {

        return repository.findAll();
    }

    public void delete(Long id) {
        Book obj = findById(id);
        repository.delete(obj);
    }
}
