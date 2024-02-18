package com.example.springio.dto;


import lombok.*;

@AllArgsConstructor
@Data
@Builder
@Setter
@NoArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private int price;
}