package com.example.springio.converter;


import com.example.springio.dto.ProductDto;
import com.example.springio.entity.Product;

public class ProductConverter {

    public static ProductDto toProductDto(Product product) {
        return ProductDto.builder().price(product.getPrice()).id(product.getId()).name(product.getName()).build();
    }

    public static Product toProduct(ProductDto productDto) {
        return Product.builder().id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
    }
}