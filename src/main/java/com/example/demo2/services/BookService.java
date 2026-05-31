package com.example.demo2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.domain.Author;
import com.example.demo2.domain.Book;
import com.example.demo2.dto.BookDTO;
import com.example.demo2.repository.AuthorRepository;
import com.example.demo2.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired private BookRepository bookRepo;
    @Autowired private AuthorRepository authorRepo;

    public Book createBook(BookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setCategory(dto.getCategory());
        book.setPublicationYear(dto.getPublicationYear());

        if (dto.getAuthorIds() != null) {
            List<Author> authors = authorRepo.findAllById(dto.getAuthorIds());
            book.setAuthors(authors);
        }
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, BookDTO dto) {
        Book book = bookRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found"));
        
        return bookRepo.save(book);
    }
    
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    
    public void deleteBook(Long id) {
        if (!bookRepo.existsById(id)) {
            throw new RuntimeException("Το βιβλίο με id " + id + " δεν βρέθηκε");
        }
        bookRepo.deleteById(id);
    }
    
    public List<Author> getAuthorsForBook(Long id) {
        Book book = bookRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Το βιβλίο με id " + id + " δεν βρέθηκε"));
        return book.getAuthors();
    }
}