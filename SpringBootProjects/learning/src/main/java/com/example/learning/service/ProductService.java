package com.example.learning.service;

import com.example.learning.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct() {}

    public void getAllProducts() {}

    public void getProductById() {}

    public void updateProduct() {}

    public void deleteProduct() {}
}
