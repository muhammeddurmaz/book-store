package com.muhammed.bookstore.service.impl;

import com.muhammed.bookstore.domain.Book;
import com.muhammed.bookstore.repository.BookRepository;
import com.muhammed.bookstore.service.BookService;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> findBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
       return bookRepository.findAll();
    }
}
