package com.muhammet.springboottest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
class SpringBootTestApplicationTests {

    @Test
    void contextLoads() {
    }

}
