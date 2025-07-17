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

    @GetMapping("/products/{productId}/stock")
    public boolean checkIfStockAvailable(
            @PathVariable("productId") Integer productId,
            @RequestParam(value = "quantity") Integer quantity
    ) {
        return productService.checkIfStockAvailable(productId, quantity);
    }

    @GetMapping("/products/{productId}")
    public ProductInformation getProductById(
            @PathVariable("productId") Integer productId
    ) {
        return productService.getProductById(productId);
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductInformation createProduct(
            @RequestBody ProductInformation productInformation
    ) {
        return productService.addProduct(productInformation);
    }

    @PostMapping("/products/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductInformation> createProducts(
            @RequestBody List<ProductInformation> productInformations
    ) {
        return productService.addProduct(productInformations);
    }

    @GetMapping("/products/search/{searchTerm}")
    public List<ProductInformation> findProductByDescription(
            @PathVariable("searchTerm") String searchTerm
    ) {
        return productService.getAllProductsByDescription(searchTerm);
    }
}
