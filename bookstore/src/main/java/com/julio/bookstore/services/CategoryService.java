package com.julio.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.bookstore.domain.Category;
import com.julio.bookstore.repositories.CategoryRespository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository respository;

    public List<Category> findAll() {

        return respository.findAll();
    }

    public Category findById(Long id) {

        Optional<Category> obj = respository.findById(id);

        return obj.get();
    }

}
