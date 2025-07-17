package org.mohaan.services;

import org.mohaan.entities.Orders;
import org.mohaan.entities.Products;
import org.mohaan.mappers.OrderMapper;
import org.mohaan.mappers.ProductMapper;
import org.mohaan.models.OrderInformation;
import org.mohaan.repositories.OrderRepository;
import org.mohaan.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public OrderService (OrderRepository orderRepository, OrderMapper orderMapper, ProductRepository productRepository, ProductMapper productMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public OrderInformation createOrder(OrderInformation orderInformation) {
        List<Products> managedProducts = orderInformation.getProducts().stream()
                .map(p -> productRepository
                                    .findById(p.getId())
                                    .orElseThrow(() -> new RuntimeException("Product not found: " + p.getId()))
                )
                .collect(Collectors.toList());

        var orderEntity = orderMapper.toEntity(orderInformation);
        orderEntity.setProducts(managedProducts);
        var savedEntity = orderRepository.save(orderEntity);
        return orderMapper.toModel(savedEntity);
    }

    public List<OrderInformation> getOrders() {
        var orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toModel)
                .collect(Collectors.toList());
    }
}
