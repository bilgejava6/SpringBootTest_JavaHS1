package com.muhammet.springboottest.service;

import com.muhammet.springboottest.entity.Product;
import com.muhammet.springboottest.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Value("${uygulamam.versiyon}")
    String versiyon;

    @Test
    void test1(){
        System.out.println("Versiyon....: "+ versiyon);
    }

    @Test
    void addProductSuccess(){
        Product product = productService.addProduct("Şeker",234d);
        Assertions.assertNotNull(product.getId());
    }

}
