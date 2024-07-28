package com.muhammet.springboottest.repository;

import com.muhammet.springboottest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
