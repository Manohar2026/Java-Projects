package com.example.learning.controller;

import com.example.learning.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void createProduct() {}

    @GetMapping
    public void getAllProducts() {}

    @GetMapping("{id}")
    public void getProductById() {}

    @PutMapping
    public void updateProduct() {}

    @DeleteMapping
    public void deleteProduct() {}
}
