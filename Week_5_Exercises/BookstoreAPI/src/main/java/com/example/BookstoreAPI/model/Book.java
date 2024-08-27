package com.example.BookstoreAPI.model;

import java.util.List;

import com.example.BookstoreAPI.dto.BookDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Fixed: Correct annotation usage
    private Long id;
    
    
    @NotNull
    @Size(min = 2, max = 100)
    private String title;
    
    

    @NotNull
    private String author;

    @Min(0)
    private double price;
    
    private String isbn;
//	public Book(Long id, String title, String author, double price, String isbn) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.author = author;
//		this.price = price;
//		this.isbn = isbn;
//	}
	
	@Version
    private Long version;

	public void setTitle(Object title2) {
		// TODO Auto-generated method stub
		
	}

	public void setAuthor(Object author2) {
		// TODO Auto-generated method stub
		
	}

	public void setPrice(Object price2) {
		// TODO Auto-generated method stub
		
	}

	public void setIsbn(Object isbn2) {
		// TODO Auto-generated method stub
		
	}

	public List<BookDTO> getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BookDTO> getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPrice() {
		// TODO Auto-generated method stub
		return null;
	}

}
