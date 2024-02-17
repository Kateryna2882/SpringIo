package com.example.springio.service;

import com.example.springio.repository.OrderRepository;
import com.example.springio.converter.OrderConverter;
import com.example.springio.dto.OrderDto;
import com.example.springio.dto.ProductDto;
import com.example.springio.exeption.OrderNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;


    public OrderDto getById(int id) {
        return orderRepository.
                findById(id).map(OrderConverter::toOrderDto)
                .orElseThrow(OrderNotFoundException::new);
    }

    public OrderDto save(OrderDto order) {

        OrderDto orderDto = OrderConverter
                .toOrderDto(this.orderRepository
                        .save(OrderConverter.toOrder(order)));

        List<ProductDto> products = productService
                .saveAll(order.getProducts(), orderDto.getId());

        orderDto.setProducts(products);
        int cost = products.stream()
                .mapToInt(ProductDto::getPrice).sum();
        orderDto.setCost(cost);

        return orderDto;
    }


    public void update(OrderDto orderDto) {
        orderRepository.findById(orderDto.getId()).ifPresent(p ->{
            p.setOwner(orderDto.getOwner());
            orderRepository.save(p);
        });
    }

    public void remove(int id) {
        productService.removeByOrderId(id);
        orderRepository.deleteById(id);
    }
}