package com.example.productService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productService.dto.ProductRequest;
import com.example.productService.dto.ProductResponse;
import com.example.productService.model.Product;
import com.example.productService.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
		
		Product product = Product.builder().name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();
		
		productRepository.save(product);
		log.info("Product {} is saved", product.getId());
		
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();
		
		return products.stream()
				.map(product -> mapToProductResponse(product))
				.collect(Collectors.toList());	
		
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder().id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice()).build();
	}

}
