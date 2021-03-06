package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.entity.Book;
import com.example.book.service.BookService;

@RestController
@RequestMapping("/booksV2")
public class BookControllerV2 {

	@Autowired
	BookService bookService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST API";
	}

	@GetMapping("/")
	public List<Book> getBookList() {
		return bookService.getList();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable long id){
		return bookService.getById(id);
		
		
	}
	
	@PostMapping("/")
	public Book addBook(@RequestBody Book book){
		bookService.addBook(book);
		return new Book();
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable long id){
		Book book = bookService.getById(id);
		bookService.deleteBook(book);
		return "Delete completed";
	}

}
