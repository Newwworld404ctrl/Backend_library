package com.example.demo2.dto;
import java.util.List;

public class BookDTO {
    private String title;
    private String isbn;
    private String category;
    private Integer publicationYear;
    private String authorName;   
    private List<Long> authorIds;

    
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
	public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }
}