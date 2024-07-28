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
        Long userid = 0l;
        if(userId==null || userid<=0)
            throw new RuntimeException("Kullanıcı id si hatalı girilmiştir.");
        return respository.findById(userid);
    }

    public void addDemoData() {
        respository.save(User.builder().userName("muhammet").password("1234").build());
        respository.save(User.builder().userName("demet").password("1234").build());
        respository.save(User.builder().userName("gunes").password("1234").build());

    }
}
