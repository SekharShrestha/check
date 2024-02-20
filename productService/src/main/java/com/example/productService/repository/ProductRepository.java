package com.example.productService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.productService.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
