package com.example.Web.Sorting.Algorithms.DAO;

import com.example.Web.Sorting.Algorithms.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("db-connect")
public class BookDaoImp implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    private static List<Book> bookArr = new ArrayList<>();

    @Autowired
    public BookDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertBook(UUID id, Book book) {
        final String sql = "INSERT INTO book (id, name, quantity, author, genre) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, id, book.getName(), book.getQuantity(), book.getAuthor(), book.getGenre());
    }

    @Override
    public List<Book> getAllBooks() {
        final String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UUID bookId = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            String author = rs.getString("author");
            String genre = rs.getString("genre");
            return new Book(bookId, name, quantity, author, genre);
        });
    }

    @Override
    public Optional<Book> getBook(UUID id) {
        final String sql = "SELECT * FROM book WHERE id = ?";
        List<Book> books = jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            UUID bookId = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            String author = rs.getString("author");
            String genre = rs.getString("genre");
            return new Book(bookId, name, quantity, author, genre);
        });

        if (books.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(books.getFirst());
        }
    }

    @Override
    public int deleteBook(UUID id) {
        final String sql = "DELETE FROM book WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateBook(UUID id, Book updatedBook) {
        final String sql = "UPDATE book SET name = ?, quantity = ?, author = ?, genre = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                updatedBook.getName(),
                updatedBook.getQuantity(),
                updatedBook.getAuthor(),
                updatedBook.getGenre(),
                id
        );
    }
}
