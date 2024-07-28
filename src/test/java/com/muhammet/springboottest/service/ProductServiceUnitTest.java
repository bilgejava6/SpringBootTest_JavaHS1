package com.muhammet.springboottest.service;

import com.muhammet.springboottest.entity.Product;
import com.muhammet.springboottest.entity.User;
import com.muhammet.springboottest.entity.UserStocks;
import com.muhammet.springboottest.repository.UserStocksRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceUnitTest {

    @InjectMocks
    private UserStocksService stocksService;
    @Mock
    private UserStocksRepository stocksRepository;
    @Mock
    private UserService userService;
    @Mock
    private ProductService productService;

    @Test
    void addStockSuccess(){
        when(userService.findOptionalById(anyLong()))
                .thenReturn(Optional.of(User.builder().id(1L).build()));
        when(productService.findOptionalByProductId(anyLong()))
                .thenReturn(Optional.of(Product.builder().id(5L).build()));
        when(stocksRepository.save(any()))
                .thenReturn(UserStocks.builder().id(1L).build());
        UserStocks userStocks = stocksService.addStock(1L,5L);
        Assertions.assertNotNull(userStocks.getId());
    }

    @Test
    void addStockUserException(){
        when(userService.findOptionalById(anyLong())).thenReturn(Optional.empty());
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,
        ()-> stocksService.addStock(1L,5L)
        );
        Assertions.assertEquals("Böyle bir kullanıcı yoktur", exception.getMessage());
    }

    @Test
    void addStockProductException(){
        when(userService.findOptionalById(anyLong()))
                .thenReturn(Optional.of(User.builder().build()));
        when(productService.findOptionalByProductId(anyLong()))
                .thenReturn(Optional.empty());
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,
                ()-> stocksService.addStock(1L,5L)
        );
        Assertions.assertEquals("Eklenecek ürün id si bulunamadı", exception.getMessage());
    }
}
