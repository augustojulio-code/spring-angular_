package com.julio.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.julio.bookstore.domain.Category;
import com.julio.bookstore.dtos.CategoryDTO;
import com.julio.bookstore.repositories.CategoryRespository;
import com.julio.bookstore.services.exceptions.DeleteIntegritViolationException;
import com.julio.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository repository;

    public List<Category> findAll() {

        return repository.findAll();
    }

    public Category findById(Long id) {

        Optional<Category> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + id + " Tipo: " + Category.class.getName()));
    }

    public Category insert(Category obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Category insert(Long id, CategoryDTO objDto) {
        Category obj = findById(id);
        obj.setName(obj.getName());
        obj.setDescription(objDto.getDescription());

        return repository.save(obj);

    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            // throw new DeleteIntegritViolationException(
            // "Não foi possivel deletar: Livros associados a categoria");
            throw new DeleteIntegritViolationException("Não foi possivel deletar: há objetos associados");
        }

    }

}
