package com.mashasoftware.onlinebookstore.purchase.service.impl;

import com.mashasoftware.onlinebookstore.book.entity.Book;
import com.mashasoftware.onlinebookstore.book.repository.BookRepository;
import com.mashasoftware.onlinebookstore.purchase.dto.CartResponseDto;
import com.mashasoftware.onlinebookstore.purchase.entity.Cart;
import com.mashasoftware.onlinebookstore.purchase.entity.Discount;
import com.mashasoftware.onlinebookstore.purchase.repository.CartRepository;
import com.mashasoftware.onlinebookstore.purchase.repository.DiscountRepository;
import com.mashasoftware.onlinebookstore.purchase.service.CartService;
import com.mashasoftware.onlinebookstore.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    CartRepository cartRepository;
    BookRepository bookRepository;
    UserRepository userRepository;
    DiscountRepository discountRepository;

    public CartServiceImpl(CartRepository cartRepository, BookRepository bookRepository, UserRepository userRepository, DiscountRepository discountRepository) {
        this.cartRepository = cartRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.discountRepository = discountRepository;
    }

    private Cart getCurrentCart(Integer userId) {
        return cartRepository.findByUserId(userId).orElseGet(Cart::new);
    }

    @Override
    public CartResponseDto getCart(Integer userId) {
        return createResponse(getCurrentCart(userId));
    }

    @Override
    public CartResponseDto addToCart(Integer userId, Integer bookId) {
        var book = bookRepository.getReferenceById(bookId);
        var cart = getCurrentCart(userId);
        var suggestedDiscount = cart.addABook(book);

        if (suggestedDiscount != null) {
            var discount = discountRepository.getReferenceById(suggestedDiscount);
            cart.offerADiscount(discount);
        }

        if (cart.getUser() == null) {
            cart.setUser(userRepository.getReferenceById(userId));
        }
        var updatedCart = cartRepository.save(cart);

        return createResponse(updatedCart);
    }

    private CartResponseDto createResponse(Cart cart) {
        return new CartResponseDto(
                cart.getId(),
                cart.getBooks().stream().map((Book::mapToBookResponseDto)).toList(),
                cart.getOfferedDiscounts().stream().map((Discount::mapToDiscountResponseDto)).toList(),
                cart.getAppliedDiscounts().stream().map((Discount::mapToDiscountResponseDto)).toList(),
    }
}