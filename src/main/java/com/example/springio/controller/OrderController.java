package com.example.springio.controller;

import com.example.springio.entity.Order;
import com.example.springio.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }
}
