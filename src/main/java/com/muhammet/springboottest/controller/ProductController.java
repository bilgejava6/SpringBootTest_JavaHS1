package com.muhammet.springboottest.controller;

import com.muhammet.springboottest.entity.Product;
import com.muhammet.springboottest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add-product")
    public ResponseEntity<Product> addProduct(String name, Double price){
      Product product = productService.addProduct(name,price);
      return ResponseEntity.ok(product);
    }
}
