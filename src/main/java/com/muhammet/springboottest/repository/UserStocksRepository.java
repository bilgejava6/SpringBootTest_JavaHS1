package com.muhammet.springboottest.repository;

import com.muhammet.springboottest.entity.UserStocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStocksRepository extends JpaRepository<UserStocks, Long> {
}
