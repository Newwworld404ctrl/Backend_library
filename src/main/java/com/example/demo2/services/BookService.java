package com.example.demo2.services;

import com.example.demo2.domain.Author;
import com.example.demo2.domain.Book;
import com.example.demo2.dto.BookDTO;
import com.example.demo2.repository.AuthorRepository;
import com.example.demo2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private AuthorRepository authorRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Το βιβλίο με id " + id + " δεν βρέθηκε"));
    }

    public Book createBook(BookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setCategory(dto.getCategory());
        book.setPublicationYear(dto.getPublicationYear());

        Book savedBook = bookRepo.save(book);

        if (dto.getAuthorName() != null && !dto.getAuthorName().trim().isEmpty()) {
            String authorName = dto.getAuthorName().trim();

            Author author = authorRepo.findByName(authorName)
                    .orElseGet(() -> {
                        Author newAuthor = new Author();
                        newAuthor.setName(authorName);
                        return authorRepo.save(newAuthor);
                    });

            savedBook.getAuthors().add(author);
            bookRepo.save(savedBook);
        }

        return savedBook;
    }

    public Book updateBook(Long id, BookDTO dto) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Το βιβλίο με id " + id + " δεν βρέθηκε"));

        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setCategory(dto.getCategory());
        book.setPublicationYear(dto.getPublicationYear());

        if (dto.getAuthorName() != null && !dto.getAuthorName().trim().isEmpty()) {
            String authorName = dto.getAuthorName().trim();

            Author author = authorRepo.findByName(authorName)
                    .orElseGet(() -> {
                        Author newAuthor = new Author();
                        newAuthor.setName(authorName);
                        return authorRepo.save(newAuthor);
                    });

            book.getAuthors().clear();
            book.getAuthors().add(author);
        }

        return bookRepo.save(book);
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