package com.example.demo2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo2.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategory(String category);
    Optional<Book> findByIsbn(String isbn);
}
