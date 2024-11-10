package com.coding.dojo.book.club.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dojo.book.club.models.Book;
import com.coding.dojo.book.club.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	// update a book
		public Book updateBook(Book book) {
			return bookRepo.save(book);
		}
		
		//delete a book
		public void deleteBook(Long id) {
			Optional<Book> optionalBook = bookRepo.findById(id);
			if(optionalBook.isPresent()) {
				bookRepo.deleteById(id);
			}
		}


}
