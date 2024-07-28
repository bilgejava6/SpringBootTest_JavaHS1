package com.muhammet.springboottest.service;

import com.muhammet.springboottest.entity.User;
import com.muhammet.springboottest.repository.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRespository respository;

    public Optional<User> findOptionalById(Long userId) {
        return respository.findById(userId);
    }
}
