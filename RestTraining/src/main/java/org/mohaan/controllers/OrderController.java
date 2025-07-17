package org.mohaan.controllers;

import org.mohaan.models.OrderInformation;
import org.mohaan.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public OrderInformation createOrder(
            @RequestBody OrderInformation order
    ) {
        // Validate the order details
        if (order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Invalid order details");
        }

        // Save the order to the repository
        return orderService.createOrder(order);
    }
}
