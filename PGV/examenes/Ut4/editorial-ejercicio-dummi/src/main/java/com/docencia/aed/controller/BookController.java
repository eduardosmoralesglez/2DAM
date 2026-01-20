package com.docencia.aed.controller;

import com.docencia.aed.entity.Book;
import com.docencia.aed.service.IBookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "Book API")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(@RequestParam(value = "authorId", required = false) Long authorId) {
        return bookService.findAll(authorId);
    }

    @Operation(summary = "Get book by ID")
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @Operation(summary = "Create a book for an author")
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestParam("authorId") Long authorId,
            @Valid @RequestBody Book book) {
        return ResponseEntity.of(Optional.of(bookService.create(authorId, book)));
    }
}
