package com.example.springio.dtoTests;

import com.example.springio.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDtoTests {

    @Test
    void testOrderDtoConstructorAndGetters() {
        OrderDto orderDto = new OrderDto(1, "John Doe", null, 0);
        assertEquals(1, orderDto.getId());
        assertEquals("John Doe", orderDto.getOwner());
        assertNull(orderDto.getProducts());
        assertEquals(0, orderDto.getCost());
    }

    @Test
    void testOrderDtoToString() {
        OrderDto orderDto = new OrderDto(1, "John Doe", null, 0);
        String expectedString = "OrderDto(id=1, owner=John Doe, products=null, cost=0)";
        assertEquals(expectedString, orderDto.toString());
    }

    @Test
    void testOrderDtoEqualsAndHashCode() {
        OrderDto orderDto1 = new OrderDto(1, "John Doe", null, 0);
        OrderDto orderDto2 = new OrderDto(1, "John Doe", null, 0);
        assertEquals(orderDto1, orderDto2);
        assertEquals(orderDto1.hashCode(), orderDto2.hashCode());
    }

    @Test
    void testOrderDtoBuilder() {
        OrderDto orderDto = OrderDto.builder()
                .id(1)
                .owner("John Doe")
                .products(null)
                .cost(0)
                .build();
        assertEquals(1, orderDto.getId());
        assertEquals("John Doe", orderDto.getOwner());
        assertNull(orderDto.getProducts());
        assertEquals(0, orderDto.getCost());
    }
}
