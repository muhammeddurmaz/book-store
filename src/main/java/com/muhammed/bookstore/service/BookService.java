package com.muhammed.bookstore.service;

import com.muhammed.bookstore.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findBookById(Integer bookId);

    List<Book> getAllBooks();
}
