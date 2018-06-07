package com.example.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookRepository bookRepo;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST API";
	}

	@GetMapping("/")
	public List<Book> getBookList() {
		return bookRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Book> getBookById(@PathVariable long id){
		return bookRepo.findById(id);
		
	}
	
	@PostMapping("/")
	public Book addBook(@RequestBody Book book){
		bookRepo.save(book);
		return new Book();
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable long id){
		Book book = bookRepo.getOne(id);
		bookRepo.delete(book);
		return "Delete completed";
	}

}
