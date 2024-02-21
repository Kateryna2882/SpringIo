package com.example.springio.repositoryTests;

import com.example.springio.entity.Order;
import com.example.springio.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testFindById() {

        Order order = new Order();
        order.setOwner("John Doe");


        Order savedOrder = orderRepository.save(order);


        Optional<Order> foundOrder = orderRepository.findById(savedOrder.getId());


        assertTrue(foundOrder.isPresent());
        assertEquals(order.getOwner(), foundOrder.get().getOwner());
    }
}
