package com.example.Web.Sorting.Algorithms.DAO;

import com.example.Web.Sorting.Algorithms.Models.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {
    void insertBook(UUID id, Book book);
    default void insertBookWithOutId(Book book){
        UUID id = UUID.randomUUID();
        insertBook(id, book);
    };
    List<Book> getAllBooks();
    Optional<Book> getBook(UUID id);
    int deleteBook(UUID id);
    int updateBook(UUID id, Book updatedBook);

}
