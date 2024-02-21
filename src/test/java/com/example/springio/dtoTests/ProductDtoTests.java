package com.example.springio.dtoTests;
import com.example.springio.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductDtoTests {

    @Test
    void testProductDtoConstructorAndGetters() {
        ProductDto productDto = new ProductDto(1, "Product", 100);
        assertEquals(1, productDto.getId());
        assertEquals("Product", productDto.getName());
        assertEquals(100, productDto.getPrice());
    }

    @Test
    void testProductDtoToString() {
        ProductDto productDto = new ProductDto(1, "Product", 100);
        String expectedString = "ProductDto(id=1, name=Product, price=100)";
        assertEquals(expectedString, productDto.toString());
    }

    @Test
    void testProductDtoEqualsAndHashCode() {
        ProductDto productDto1 = new ProductDto(1, "Product", 100);
        ProductDto productDto2 = new ProductDto(1, "Product", 100);
        assertEquals(productDto1, productDto2);
        assertEquals(productDto1.hashCode(), productDto2.hashCode());
    }

    @Test
    void testProductDtoBuilder() {
        ProductDto productDto = ProductDto.builder()
                .id(1)
                .name("Product")
                .price(100)
                .build();
        assertEquals(1, productDto.getId());
        assertEquals("Product", productDto.getName());
        assertEquals(100, productDto.getPrice());
    }
}
