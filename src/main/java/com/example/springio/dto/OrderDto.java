package com.example.springio.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@Setter
@NoArgsConstructor
public class OrderDto {
    private int id;
    private String owner;

    private List<ProductDto> products;
    private int cost;

}