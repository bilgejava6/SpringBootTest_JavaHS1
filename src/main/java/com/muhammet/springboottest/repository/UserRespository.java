package com.muhammet.springboottest.repository;

import com.muhammet.springboottest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Long> {
}
