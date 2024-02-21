package com.example.springio.converter;


import com.example.springio.dto.OrderDto;
import com.example.springio.entity.Order;

import java.sql.Date;
import java.time.LocalDate;

public class OrderConverter {

    public static OrderDto toOrderDto(Order order) {
        return OrderDto.builder().id(order.getId()).owner(order.getOwner()).build();
    }

    public static Order toOrder(OrderDto orderDto) {
        return Order.builder().id(orderDto.getId()).owner(orderDto.getOwner())
                .createdDate(Date.valueOf(LocalDate.now())).build();
    }
}