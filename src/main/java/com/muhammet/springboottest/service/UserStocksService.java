package com.muhammet.springboottest.service;

import com.muhammet.springboottest.entity.Product;
import com.muhammet.springboottest.entity.User;
import com.muhammet.springboottest.entity.UserStocks;
import com.muhammet.springboottest.repository.UserStocksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserStocksService {
    private final UserStocksRepository repository;
    private final UserService userService;
    private final ProductService productService;

    public UserStocks addStock(Long userId, Long productId){
        Optional<User>  userOptional = userService.findOptionalById(userId);
        if(userOptional.isEmpty()) throw new RuntimeException("Böyle bir kullanıcı yoktur");
        Optional<Product> productOptional = productService.findOptionalByProductId(productId);
        if(productOptional.isEmpty()) throw new RuntimeException("Eklenecek ürün id si bulunamadı");
        return repository.save(
          UserStocks.builder()
                  .count(1)
                  .productId(productId)
                  .userId(userId)
                  .build()
        );
    }
}
