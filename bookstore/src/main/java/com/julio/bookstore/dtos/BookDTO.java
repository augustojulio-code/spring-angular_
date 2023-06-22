package com.julio.bookstore.dtos;

import java.io.Serializable;

import com.julio.bookstore.domain.Book;

public class BookDTO implements Serializable {

    private Long id;
    private String title;

    public BookDTO() {
        super();
    }

    public BookDTO(Book obj) {
        super();
        this.id = obj.getId();
        this.title = obj.getTitle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
