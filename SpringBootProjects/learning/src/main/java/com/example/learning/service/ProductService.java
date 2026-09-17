package com.example.learning.service;

import com.example.learning.dto.request.ProductRequest;
import com.example.learning.dto.response.ProductResponse;
import com.example.learning.entity.Product;
import com.example.learning.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        productRepository.save(mapToEntity(productRequest));
    }

    public void getAllProducts() {}

    public void getProductById(Long id) {}

    public void updateProduct(ProductRequest productRequest) {}

    public void deleteProductById(Long id) {}

    private Product mapToEntity(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());

        return product;
    }

    private ProductResponse mapToDto(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(product.getQuantity());

        return productResponse;
    }
}
