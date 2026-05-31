package com.example.demo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo2.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByNationality(String nationality);
}