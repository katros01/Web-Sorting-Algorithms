package com.example.Web.Sorting.Algorithms.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Book {
    private UUID id;
    private String name;
    private int quantity;
    private String author;
    private String genre;

    public Book(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("quantity") int quantity, @JsonProperty("author") String author, @JsonProperty("genre") String genre){
        this.id = id;
        this.name = name ;
        this.quantity = quantity;
        this.author = author;
        this.genre = genre;
    };

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
