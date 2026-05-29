package com.mashasoftware.onlinebookstore.purchase.service;

import com.mashasoftware.onlinebookstore.purchase.dto.CartResponseDto;


public interface CartService {
    CartResponseDto getCart(Integer userId);

    CartResponseDto addToCart(Integer userId, Integer bookId);

    void deleteCart(Integer userId);
}