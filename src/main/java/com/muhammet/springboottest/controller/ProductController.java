package com.muhammet.springboottest.controller;

import com.muhammet.springboottest.dto.request.AddProductRequestDto;
import com.muhammet.springboottest.entity.Product;
import com.muhammet.springboottest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add-product")
    @CrossOrigin("*")
    public ResponseEntity<Product> addProduct(@RequestBody AddProductRequestDto dto){
      Product product = productService.addProduct(dto.getName(), dto.getPrice());
      return ResponseEntity.ok(product);
    }
}
