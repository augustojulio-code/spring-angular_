package com.julio.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julio.bookstore.domain.Category;
import com.julio.bookstore.dtos.CategoryDTO;
import com.julio.bookstore.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryResources {

    @Autowired
    private CategoryService service;

    /*
     * @GetMapping
     * public ResponseEntity<List<Category>> findAll() {
     * 
     * List<Category> list = service.findAll();
     * 
     * return ResponseEntity.ok().body(list);
     * }
     */

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = service.findById(id);

        return ResponseEntity.ok().body(obj);

    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {

        List<Category> list = service.findAll();
        List<CategoryDTO> listDto = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

}
