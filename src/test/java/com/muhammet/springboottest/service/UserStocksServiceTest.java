package com.muhammet.springboottest.service;

import com.muhammet.springboottest.entity.UserStocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserStocksServiceTest {

    /**
     * Test işlemleri H2DB üzerinde işlenirse, H2 ram üzerinde çalıştığı
     * için verileri kayıt etmek. Uygulama çalıştığı sürece DB de kayıt
     * olur.
     * Eğer test işlemleri için gerekli datalar yok ise, test
     * işleminden önce gerekli datalar DB ye kayıt edilmelidir.
     */
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @BeforeEach
    void herTesttenOnce(){
        userService.addDemoData();
        productService.addDemoData();
    }
    @Autowired
    private UserStocksService service;

    @Test
    void addStockSuccess() {
        UserStocks userStocks = service.addStock(1L, 2L);
        Assertions.assertNotNull(userStocks.getId());
    }

    @Test
    void addStockNotFoundUserException(){
        RuntimeException runtimeException =
                Assertions.assertThrows(RuntimeException.class,()->
                        service.addStock(100L,2L)
                        );
        Assertions.assertEquals(
                "Böyle bir kullanıcı yoktur",
                runtimeException.getMessage());
    }

    @Test
    void addStockNotFoundProductException(){
        RuntimeException runtimeException =
                Assertions.assertThrows(RuntimeException.class,()->
                        service.addStock(1L,20L)
                );
        Assertions.assertEquals(
                "Eklenecek ürün id si bulunamadı",
                runtimeException.getMessage());
    }
}