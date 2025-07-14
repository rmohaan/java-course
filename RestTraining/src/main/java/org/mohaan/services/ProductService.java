package org.mohaan.services;

import jakarta.annotation.PostConstruct;
import org.mohaan.mappers.ProductMapper;
import org.mohaan.models.ProductInformation;
import org.mohaan.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    public List<ProductInformation> allProducts;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

//    @PostConstruct
//    public void init() {
//        allProducts.add(new ProductInformation(1, "Headphone", "Bluetooth Headphone", 10));
//        allProducts.add(new ProductInformation(2, "Mobile", "Smartphone with 128GB storage", 20));
//        allProducts.add(new ProductInformation(3, "Tablet", "10-inch tablet with Wi-Fi", 15));
//        allProducts.add(new ProductInformation(4, "Laptop", "15-inch laptop with 16GB RAM", 5));
//        allProducts.add(new ProductInformation(5, "Smartwatch", "Fitness smartwatch with heart rate monitor", 8));
//    }

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        allProducts = new ArrayList<>();
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductInformation> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toModel)
                .toList();
    }

    public ProductInformation addProduct(ProductInformation productInformation) {
        var productEntity = productMapper.toEntity(productInformation);
        var savedEntity = productRepository.save(productEntity);
        return productMapper.toModel(savedEntity);
    }

    public ProductInformation getProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toModel)
                .orElse(null);
    }

    public boolean checkIfStockAvailable(Integer productId, Integer quantity) {
        return productRepository.findById(productId)
                .map(productMapper::toModel)
                .filter(productInfo -> productInfo.getQuantity() >= quantity)
                .isPresent();
    }
}
