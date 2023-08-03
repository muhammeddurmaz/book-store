package com.muhammed.bookstore.web.rest;


import com.muhammed.bookstore.domain.Book;
import com.muhammed.bookstore.domain.Order;
import com.muhammed.bookstore.dto.BookDTO;
import com.muhammed.bookstore.dto.BookOrderRequest;
import com.muhammed.bookstore.service.BookService;
import com.muhammed.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookStoreResource {

    private final OrderService orderService;
    private final BookService bookService;

    public BookStoreResource(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        return ResponseEntity.ok(orderList);
    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        Order order = orderService.putOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());

        return ResponseEntity.ok(order);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.name);
        Book savedBook = bookService.createBook(book);
        return ResponseEntity.ok(savedBook);
    }
}
