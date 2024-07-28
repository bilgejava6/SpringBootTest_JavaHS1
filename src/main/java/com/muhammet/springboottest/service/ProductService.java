package com.muhammet.springboottest.service;

import com.muhammet.springboottest.entity.Product;
import com.muhammet.springboottest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Product addProduct(String name, Double price) {
        return repository.save(
                Product.builder()
                        .name(name)
                        .price(price)
                        .build()
        );
    }

    public Optional<Product> findOptionalByProductId(Long productId) {
        return repository.findById(productId);
    }

    public void addDemoData() {
        repository.save(Product.builder().name("şeker").price(34d).build());
        repository.save(Product.builder().name("un").price(64d).build());
        repository.save(Product.builder().name("yağ").price(234d).build());
        repository.save(Product.builder().name("süt").price(90d).build());

    }
}
