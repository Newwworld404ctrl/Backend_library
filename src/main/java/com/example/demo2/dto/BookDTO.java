package com.example.demo2.dto;

import java.util.List;

//BookDTO.java
public class BookDTO {
 private Long id;
 private String title;
 private String isbn;
 private String category;
 private Integer publicationYear;
 private List<Long> authorIds;
 public Long getId() {
	return id;
 }
 public void setId(Long id) {
	this.id = id;
 }
 public String getTitle() {
	return title;
 }
 public void setTitle(String title) {
	this.title = title;
 }
 public String getIsbn() {
	return isbn;
 }
 public void setIsbn(String isbn) {
	this.isbn = isbn;
 }
 public String getCategory() {
	return category;
 }
 public void setCategory(String category) {
	this.category = category;
 }
 public Integer getPublicationYear() {
	return publicationYear;
 }
 public void setPublicationYear(Integer publicationYear) {
	this.publicationYear = publicationYear;
 }
 public List<Long> getAuthorIds() {
	return authorIds;
 }
 public void setAuthorIds(List<Long> authorIds) {
	this.authorIds = authorIds;
 }  
}
