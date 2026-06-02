package com.example.demo2.controller;

import com.example.demo2.domain.Author;
import com.example.demo2.domain.Book;
import com.example.demo2.dto.AuthorDTO;
import com.example.demo2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // GET /authors
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    // GET /authors/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    // POST /authors
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorDTO dto) {
        return ResponseEntity.status(201).body(authorService.createAuthor(dto));
    }

    // PUT /authors/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO dto) {
        return ResponseEntity.ok(authorService.updateAuthor(id, dto));
    }

    // DELETE /authors/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    // GET /authors/{id}/books
    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getAuthorBooks(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getBooksForAuthor(id));
    }
}