package com.example.springio.serviceTests;
import com.example.springio.converter.ProductConverter;
import com.example.springio.dto.ProductDto;
import com.example.springio.repository.ProductRepository;
import com.example.springio.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testSave() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        Mockito.when(productRepository.save(any())).thenReturn(ProductConverter.toProduct(productDto));
        assertEquals(productDto, productService.save(productDto, 1));
    }

    @Test
    void testSaveAll() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        List<ProductDto> productList = Collections.singletonList(productDto);
        Mockito.when(productRepository.save(any())).thenReturn(ProductConverter.toProduct(productDto));
        assertEquals(productList, productService.saveAll(productList, 1));
    }

    @Test
    void testDelete() {
        productService.delete(1);
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    void testRemoveByOrderId() {
        productService.removeByOrderId(1);
        Mockito.verify(productRepository, Mockito.times(1))
                .deleteAllByOrderId(1);
    }
}
