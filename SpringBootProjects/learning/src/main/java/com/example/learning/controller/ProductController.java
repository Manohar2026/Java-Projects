package com.example.learning.controller;

import com.example.learning.dto.request.ProductRequest;
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
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    public void getAllProducts() {}

    @GetMapping("{id}")
    public void getProductById(@RequestParam Long id) {}

    @PutMapping
    public void updateProduct() {}

    @DeleteMapping("{id}")
    public void deleteProductById(@RequestParam Long id) {}
}
