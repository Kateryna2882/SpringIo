package com.example.springio.serviceTests;
import com.example.springio.converter.OrderConverter;
import com.example.springio.dto.OrderDto;
import com.example.springio.repository.OrderRepository;
import com.example.springio.service.OrderService;
import com.example.springio.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest
class OrderServiceTests {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductService productService;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testGetById() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        Mockito.when(orderRepository.findById(1)).thenReturn(Optional.of(OrderConverter.toOrder(orderDto)));
        assertNotNull(orderService.getById(1));
    }

    @Test
    void testSave() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        Mockito.when(orderRepository.save(Mockito.any())).thenReturn(OrderConverter.toOrder(orderDto));
        assertNotNull(orderService.save(orderDto));
    }

    @Test
    void testUpdate() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        Mockito.when(orderRepository.findById( anyInt())).thenReturn(Optional.of(OrderConverter.toOrder(orderDto)));
        orderService.update(orderDto);
        Mockito.verify(orderRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void testRemove() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        orderService.remove(1);
        Mockito.verify(productService, Mockito.times(1)).removeByOrderId(1);
        Mockito.verify(orderRepository, Mockito.times(1)).deleteById(1);
    }
}
