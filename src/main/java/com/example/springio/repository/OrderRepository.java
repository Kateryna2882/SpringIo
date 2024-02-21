package com.example.springio.repository;

import com.example.springio.entity.Order;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@ComponentScan
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}