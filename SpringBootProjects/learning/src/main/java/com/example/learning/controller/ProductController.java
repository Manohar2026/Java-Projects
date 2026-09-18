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
    public String createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return "Successfull";
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping
    public String updateProduct(@RequestBody ProductRequest productRequest) {
        productService.updateProduct(productRequest);
        return "Successfully updated";
    }

    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "Deleted";
    }
}
