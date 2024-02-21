package com.example.springio.entity;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Integer price;

    @Column(name = "order_Id")
    private int orderId;

    public Product(String name, int orderId) {
        this.name = name;
        this.orderId = orderId;
    }
}
