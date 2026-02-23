package com.johncnstn.catalog_service.controller;

import com.johncnstn.catalog_service.entity.Order;
import com.johncnstn.catalog_service.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void initOrdersTable() {
        List<Order> orders = List.of(
                new Order("mobile", "electronics", "white", 20000),
                new Order("T-Shirt", "clothes", "black", 999),
                new Order("Jeans", "clothes", "blue", 1999),
                new Order("Laptop", "electronics", "gray", 50000),
                new Order("digital watch", "electronics", "black", 2500),
                new Order("Fan", "electronics", "black", 50000)
        );
        orderRepository.saveAll(orders);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
