package com.shoping.productservice.controller;

import com.shoping.productservice.dto.ProductRequest;
import com.shoping.productservice.dto.ProductResponse;
import com.shoping.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct (@RequestBody ProductRequest productRequest){
        service.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return service.getAllProducts();
    }
}
