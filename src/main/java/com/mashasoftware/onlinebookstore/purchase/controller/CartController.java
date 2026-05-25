package com.mashasoftware.onlinebookstore.purchase.controller;

import com.mashasoftware.onlinebookstore.purchase.dto.CartResponseDto;
import com.mashasoftware.onlinebookstore.purchase.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public CartResponseDto getCurrentCart(@RequestParam Integer userId) {
        return cartService.getCart(userId);
    }

    @PostMapping("/")
    public CartResponseDto addToCart(@RequestParam Integer userId, @RequestParam Integer bookId) {
        return cartService.addToCart(userId, bookId);
    }

}
