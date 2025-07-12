package org.mohaan.controllers;

import org.mohaan.models.ProductInformation;
import org.mohaan.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductInformation> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductInformation createProduct(
            @RequestBody ProductInformation productInformation
    ) {
        return productService.addProduct(productInformation);
    }
}
