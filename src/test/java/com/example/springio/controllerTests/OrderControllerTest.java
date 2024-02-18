package com.example.springio.controllerTests;
import com.example.springio.controller.OrderController;
import com.example.springio.dto.OrderDto;
import com.example.springio.dto.ProductDto;
import com.example.springio.service.OrderService;
import com.example.springio.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private ProductService productService;

    @InjectMocks
    private OrderController orderController;

    @Test
    void testGetById() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        when(orderService.getById(1)).thenReturn(orderDto);

        OrderDto result = orderController.getById(1);

        assertEquals(orderDto, result);
        verify(orderService, times(1)).getById(1);
    }

    @Test
    void testUpdate() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        doNothing().when(orderService).update(orderDto);

        orderController.update(orderDto);

        verify(orderService, times(1)).update(orderDto);
    }

    @Test
    void testSave() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        when(orderService.save(any(OrderDto.class))).thenReturn(orderDto);

        OrderDto result = orderController.save(orderDto);

        assertEquals(orderDto, result);
        verify(orderService, times(1)).save(orderDto);
    }

    @Test
    void testAddProduct() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        when(productService.save(any(ProductDto.class), anyInt())).thenReturn(productDto);

        ProductDto result = orderController.addProduct(1, productDto);

        assertEquals(productDto, result);
        verify(productService, times(1)).save(productDto, 1);
    }

    @Test
    void testRemove() {
        doNothing().when(orderService).remove(anyInt());

        orderController.remove(1);

        verify(orderService, times(1)).remove(1);
    }
}
