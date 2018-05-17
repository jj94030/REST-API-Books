package com.example.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book.entity.Book;

@Service
public class BookService {

	private List<Book> list;

	public BookService() {
		list = new ArrayList<>();
		list.add(new Book(1, "Thinking in JAVA", " Bruce Eckel", "43531"));
		list.add(new Book(2, "Clean Code", " Robert Cecil Martin", "12316"));
	}

	public List<Book> getList() {
		return list;
	}

	public Book getById(long id) {

		for (Book b : list) {
			if (b.getId() == id) {
				return b;
			}
		}
		return null;
	}
	
	public void addBook(Book book){
		list.add(book);
	}
	
	public void deleteBook(Book book){
		list.remove(book);
	}
}
