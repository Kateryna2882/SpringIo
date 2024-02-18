package com.example.springio.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Product {
    @Id
    private int id;
    private String name;
    private int price;
    private int orderId;
}
