package com.julio.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julio.bookstore.domain.Category;

public interface CategoryRespository extends JpaRepository<Category, Long> {

}
