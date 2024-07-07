package com.example.Web.Sorting.Algorithms.Models;

import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

public class BookShema extends RepresentationModel<BookShema> {
    private UUID id;
    private String name;
    private int quantity;
    private String author;
    private String genre;

    public BookShema(UUID id, String name, int quantity, String author, String genre) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.author = author;
        this.genre = genre;
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
