package com.bharath.springcloud.controller;

import com.bharath.springcloud.model.Product;
import com.bharath.springcloud.repository.ProductRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping("/products")
    Product create(@RequestBody Product product){
        return productRepo.save(product);
    }
}
