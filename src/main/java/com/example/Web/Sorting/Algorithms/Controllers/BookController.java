package com.example.Web.Sorting.Algorithms.Controllers;

import com.example.Web.Sorting.Algorithms.Models.Book;
import com.example.Web.Sorting.Algorithms.Models.BookShema;
import com.example.Web.Sorting.Algorithms.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/books")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<BookShema>> addBook(@RequestBody Book book){
            bookService.addBook(book);
            BookShema bookModel = new BookShema(book.getId(), book.getName(), book.getQuantity(), book.getAuthor(), book.getGenre());
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBook(book.getId())).withSelfRel();
            Link updateLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).updateBook(book.getId(), book)).withRel("update");
            Link deleteLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).deleteBook(book.getId())).withRel("delete");
            bookModel.add(selfLink, updateLink, deleteLink);
            return new ResponseEntity<>(EntityModel.of(bookModel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<BookShema>>>  getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<EntityModel<BookShema>> bookModels = books.stream()
                .map(book -> {
                    BookShema bookModel = new BookShema(book.getId(), book.getName(), book.getQuantity(), book.getAuthor(), book.getGenre());
                    Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBook(book.getId())).withSelfRel();
                    Link updateLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).updateBook(book.getId(), book)).withRel("update");
                    Link deleteLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).deleteBook(book.getId())).withRel("delete");
                    bookModel.add(selfLink, updateLink, deleteLink);
                    return EntityModel.of(bookModel);
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(bookModels, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<EntityModel<BookShema>> getBook(@PathVariable("id") UUID id) {
        Optional<Book> bookFound = bookService.getBookById(id);

        if (bookFound.isPresent()) {
            Book book = bookFound.get();
            BookShema bookModel = new BookShema(book.getId(), book.getName(), book.getQuantity(), book.getAuthor(), book.getGenre());
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBook(id)).withSelfRel();
            Link updateLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).updateBook(id, book)).withRel("update");
            Link deleteLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).deleteBook(id)).withRel("delete");
            Link allBooksLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("allBooks");
            bookModel.add(selfLink, updateLink, deleteLink, allBooksLink);
            return new ResponseEntity<>(EntityModel.of(bookModel), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public  ResponseEntity<Object>deleteBook(@PathVariable("id") UUID id) {

        int result = bookService.deleteBook(id);
        if (result > 0) {
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<EntityModel<BookShema>> updateBook(@PathVariable("id") UUID id, @RequestBody Book updatedBook) {
        int result = bookService.updateBook(id, updatedBook);
        if (result > 0) {
            BookShema bookModel = new BookShema(updatedBook.getId(), updatedBook.getName(), updatedBook.getQuantity(), updatedBook.getAuthor(), updatedBook.getGenre());
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBook(id)).withSelfRel();
            Link deleteLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).deleteBook(id)).withRel("delete");
            bookModel.add(selfLink, deleteLink);
            return new ResponseEntity<>(EntityModel.of(bookModel), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
