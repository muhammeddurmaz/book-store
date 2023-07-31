package com.muhammed.bookstore.service;

import com.muhammed.bookstore.domain.Order;

import java.util.List;

public interface OrderService {

        Order putOrder(List<Integer> bookIdList, String userName);

        List<Order> getAllOrders();
}
