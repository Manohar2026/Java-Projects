package com.example.learning.controller;

import com.example.learning.dto.request.ProductRequest;
import com.example.learning.dto.response.ProductResponse;
import com.example.learning.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ProductResponse getProductById(@RequestParam Long id) {
        return productService.getProductById(id);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductRequest productRequest) {
        productService.updateProduct(productRequest);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@RequestParam Long id) {
        productService.deleteProductById(id);
    }
}
