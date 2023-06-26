package com.julio.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.julio.bookstore.domain.Book;
import com.julio.bookstore.dtos.BookDTO;
import com.julio.bookstore.services.BookService;

@RestController
@RequestMapping("/books")
public class BookResources {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Long id_cat) {
        List<Book> list = service.findAll(id_cat);
        List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book obj) {
        Book newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updatePatch(@PathVariable Long id, @RequestBody Book obj) {
        Book newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

}
