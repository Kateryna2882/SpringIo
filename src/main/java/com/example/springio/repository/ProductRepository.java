package com.example.springio.repository;


import com.example.springio.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    void deleteAllByOrderId(int id);
}