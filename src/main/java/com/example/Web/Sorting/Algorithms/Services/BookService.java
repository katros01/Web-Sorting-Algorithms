package com.example.Web.Sorting.Algorithms.Services;

import com.example.Web.Sorting.Algorithms.DAO.BookDaoImp;
import com.example.Web.Sorting.Algorithms.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private final BookDaoImp newBook;

    @Autowired
    public BookService(@Qualifier("db-connect") BookDaoImp newBook) {
        this.newBook = newBook;
    }

    public void addBook(Book book) {

        newBook.insertBookWithOutId(book);
    }

    public List<Book> getAllBooks() {

        return  newBook.getAllBooks();
    }

    public Optional<Book> getBookById(UUID id){
        return newBook.getBook(id);
    }

    public int deleteBook(UUID id) {
        return newBook.deleteBook(id);
    }

    public int updateBook(UUID id, Book updatedBook) {
        return newBook.updateBook(id, updatedBook);
    }
}
