package com.julio.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/{id}")
    ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO objDto) {
        Category newObj = service.insert(id, objDto);

        return ResponseEntity.ok().body(new CategoryDTO(newObj));

    }

}
