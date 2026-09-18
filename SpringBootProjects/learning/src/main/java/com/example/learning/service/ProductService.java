package com.example.learning.service;

import com.example.learning.dto.request.ProductRequest;
import com.example.learning.dto.response.ProductResponse;
import com.example.learning.entity.Product;
import com.example.learning.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        productRepository.save(mapToEntity(productRequest));
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> responses = new ArrayList<>();

        for(Product product : products) {
            responses.add(mapToDto(product));
        }

        return responses;
    }

    public ProductResponse getProductById(Long id) {
        return mapToDto(productRepository.findById(id).orElse(null));
    }

    public void updateProduct(ProductRequest productRequest) {
        Product product = productRepository.findById(productRequest.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());

        productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

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
