package com.shoping.productservice.service;

import com.shoping.productservice.dto.ProductRequest;
import com.shoping.productservice.dto.ProductResponse;
import com.shoping.productservice.model.Product;
import com.shoping.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    public final ProductRepository repository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        repository.save(product);
        log.info("Product {} is saved.", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = repository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
