package com.coding.dojo.book.club.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.dojo.book.club.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    
    List<Book> findAll();
    
}
