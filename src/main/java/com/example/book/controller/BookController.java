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
	//BookService bookService;
	BookRepository bookRepo;
	@RequestMapping("/hello")
	public String hello() {
		return "asdfasdf";
	}

	@GetMapping("/")
	public List<Book> getBookList() {
		//return bookService.getList();
		return bookRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Book> getBookById(@PathVariable long id){
		//return bookService.getById(id);
		return bookRepo.findById(id);
		
	}
	
	@PostMapping("/")
	public Book addBook(@RequestBody Book book){
		//bookService.addBook(book);
		bookRepo.save(book);
		return new Book();
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable long id){
		//Book book = bookService.getById(id);
		//bookService.deleteBook(book);
		Book book = bookRepo.getOne(id);
		bookRepo.delete(book);
		return "Delete completed";
	}

}
