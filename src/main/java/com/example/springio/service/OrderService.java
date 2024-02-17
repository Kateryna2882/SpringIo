package com.example.springio.service;

import com.example.springio.entity.Order;
import com.example.springio.repository.OrderRepository;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class OrderService {
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return this.orderRepository.save(order);
    }
}
