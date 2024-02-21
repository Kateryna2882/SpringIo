package com.example.springio.converterTests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.springio.converter.OrderConverter;
import org.junit.jupiter.api.Test;
import com.example.springio.dto.OrderDto;
import com.example.springio.entity.Order;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
public class OrderConverterTest {

    @Test
    void testToOrderDto() {

        Order order = new Order();
        order.setId(1);
        order.setOwner("John Doe");

        OrderDto orderDto = OrderConverter.toOrderDto(order);


        assertEquals(order.getId(), orderDto.getId());
        assertEquals(order.getOwner(), orderDto.getOwner());
    }

    @Test
    void testToOrder() {

        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        orderDto.setOwner("John Doe");

        Order order = OrderConverter.toOrder(orderDto);

        assertEquals(orderDto.getId(), order.getId());
        assertEquals(orderDto.getOwner(), order.getOwner());
        assertEquals(Date.valueOf(LocalDate.now()), order.getCreatedDate());
    }
}
