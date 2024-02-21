package com.example.springio.repositoryTests;

import com.example.springio.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ProductRepositoryTest {

    @Test
    void testDeleteAllByOrderId() {

        ProductRepository productRepository = mock(ProductRepository.class);
        int orderId = 1;


        productRepository.deleteAllByOrderId(orderId);

        verify(productRepository, times(1)).deleteAllByOrderId(orderId);
    }
}
