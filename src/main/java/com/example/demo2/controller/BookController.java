package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.domain.Author;
import com.example.demo2.domain.Book;
import com.example.demo2.dto.BookDTO;
import com.example.demo2.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")  
public class BookController {

    @Autowired private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookDTO dto) {
        return ResponseEntity.status(201).body(bookService.createBook(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO dto) {
        return ResponseEntity.ok(bookService.updateBook(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/authors")
    public ResponseEntity<List<Author>> getBookAuthors(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getAuthorsForBook(id));
    }
}