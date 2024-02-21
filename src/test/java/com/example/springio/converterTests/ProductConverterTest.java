package com.example.springio.converterTests;
import com.example.springio.converter.ProductConverter;
import com.example.springio.dto.ProductDto;
import com.example.springio.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductConverterTest {

    @Test
    void testToProductDto() {
        Product product = new Product();
        product.setId(1);
        product.setName("Test Product");
        product.setPrice(10);


        ProductDto productDto = ProductConverter.toProductDto(product);


        assertEquals(product.getId(), productDto.getId());
        assertEquals(product.getName(), productDto.getName());
        assertEquals(product.getPrice(), productDto.getPrice());
    }

    @Test
    void testToProduct() {

        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Test Product");
        productDto.setPrice(10);


        Product product = ProductConverter.toProduct(productDto);


        assertEquals(productDto.getId(), product.getId());
        assertEquals(productDto.getName(), product.getName());
        assertEquals(productDto.getPrice(), product.getPrice());
    }
}
