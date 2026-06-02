package com.example.demo2.services;

import com.example.demo2.domain.Author;
import com.example.demo2.domain.Book;
import com.example.demo2.dto.AuthorDTO;
import com.example.demo2.repository.AuthorRepository;
import com.example.demo2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;

    @Autowired
    private BookRepository bookRepo;

    
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    
    public Author getAuthorById(Long id) {
        return authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ο συγγραφέας με id " + id + " δεν βρέθηκε"));
    }

    
    public Author createAuthor(AuthorDTO dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setNationality(dto.getNationality());
        author.setBirthDate(dto.getBirthDate());
        return authorRepo.save(author);
    }

    
    public Author updateAuthor(Long id, AuthorDTO dto) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ο συγγραφέας με id " + id + " δεν βρέθηκε"));
        author.setName(dto.getName());
        author.setNationality(dto.getNationality());
        author.setBirthDate(dto.getBirthDate());
        return authorRepo.save(author);
    }

    
    public void deleteAuthor(Long id) {
        if (!authorRepo.existsById(id)) {
            throw new RuntimeException("Ο συγγραφέας με id " + id + " δεν βρέθηκε");
        }
        authorRepo.deleteById(id);
    }

    
    public List<Book> getBooksForAuthor(Long id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ο συγγραφέας με id " + id + " δεν βρέθηκε"));
        return author.getBooks();
    }
}