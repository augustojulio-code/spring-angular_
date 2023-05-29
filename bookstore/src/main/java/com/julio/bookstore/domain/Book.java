package com.julio.bookstore.domain;

public class Book {

    private Long id;
    private String name;
    private String author;
    private String text;

    private Category category;

    public Book() {

    }

    public Book(Long id, String name, String author, String text, Category category) {

        this.id = id;
        this.name = name;
        this.author = author;
        this.text = text;
        this.category = category;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.name;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setDesc(String author) {
        this.author = author;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
