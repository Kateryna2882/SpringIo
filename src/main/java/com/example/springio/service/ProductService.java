package com.example.springio.service;


import com.example.springio.converter.ProductConverter;
import com.example.springio.dto.ProductDto;
import com.example.springio.entity.Product;
import com.example.springio.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository productRepository;

    public List<ProductDto> saveAll(List<ProductDto> products, int orderId) {
        if (products == null) {
            return Collections.emptyList();
        }
        return products.stream()
                .map(p -> save(p, orderId))
                .collect(Collectors.toList());
    }



    public ProductDto save(ProductDto product, int orderId) {

        Product productEntity = ProductConverter.toProduct(product);
        productEntity.setOrderId(orderId);
        productEntity = this.productRepository.save(productEntity);

        return ProductConverter.toProductDto(productEntity);
    }


    public void delete(int id) {
        this.productRepository.deleteById(id);
    }

    public void removeByOrderId(int id) {
        productRepository.deleteAllByOrderId(id);
    }
}