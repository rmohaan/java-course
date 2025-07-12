package org.mohaan.services;

import jakarta.annotation.PostConstruct;
import org.mohaan.models.ProductInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    public List<ProductInformation> allProducts;


    @PostConstruct
    public void init() {
        allProducts.add(new ProductInformation(1, "Headphone", "Bluetooth Headphone"));
        allProducts.add(new ProductInformation(2, "Mobile", "Smartphone with 128GB storage"));
        allProducts.add(new ProductInformation(3, "Tablet", "10-inch tablet with Wi-Fi"));
        allProducts.add(new ProductInformation(4, "Laptop", "15-inch laptop with 16GB RAM"));
        allProducts.add(new ProductInformation(5, "Smartwatch", "Fitness smartwatch with heart rate monitor"));
    }

    public ProductService() {
        allProducts = new ArrayList<>();
    }

    public List<ProductInformation> getAllProducts() {
        return allProducts;
    }

    public ProductInformation addProduct(ProductInformation productInformation) {
        allProducts.add(productInformation);
        return allProducts.stream()
                .filter(product -> Objects.equals(product.getId(), productInformation.getId()))
                .findFirst().orElseThrow();
    }
}
