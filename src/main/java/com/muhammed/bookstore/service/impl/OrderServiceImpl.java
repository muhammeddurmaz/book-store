package com.muhammed.bookstore.service.impl;

import com.muhammed.bookstore.domain.Book;
import com.muhammed.bookstore.domain.Order;
import com.muhammed.bookstore.repository.OrderRepository;
import com.muhammed.bookstore.service.BookService;
import com.muhammed.bookstore.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final BookService bookService;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order putOrder(List<Integer> bookIdList, String userName) {
        List<Optional<Book>> bookList;
        bookList = bookIdList.stream()
                .map(bookService::findBookById).collect(Collectors.toList());

        Double totalPrice = bookList.stream()
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
                .reduce(0.0, Double::sum);

        Order order = Order.builder()
                .bookIdList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
