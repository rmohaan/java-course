package org.mohaan.controllers;

import jakarta.validation.Valid;
import org.mohaan.models.OrderInformation;
import org.mohaan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public OrderInformation createOrder(
           @Valid @RequestBody OrderInformation order
    ) {
        // Validate the order details
        if (order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Invalid order details");
        }

        // Save the order to the repository
        return orderService.createOrder(order);
    }

    @GetMapping("/orders")
    public List<OrderInformation> getOrders() {
        return orderService.getOrders();
    }
}
