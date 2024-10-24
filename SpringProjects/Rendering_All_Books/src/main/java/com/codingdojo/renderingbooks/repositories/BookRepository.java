package com.codingdojo.renderingbooks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.renderingbooks.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findAll();

}