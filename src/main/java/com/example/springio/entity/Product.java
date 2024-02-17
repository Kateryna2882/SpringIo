package com.example.springio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
public class Product {
    @Id
    private int id;
    private String name;
    private int price;
    private int orderId;
}
