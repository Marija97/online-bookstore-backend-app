package com.mashasoftware.onlinebookstore.purchase.dto;

import com.mashasoftware.onlinebookstore.book.dto.BookResponseDto;
import com.mashasoftware.onlinebookstore.book.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public record CartResponseDto(Integer id, List<BookResponseDto> books, List<DiscountResponseDto> offeredDiscounts,
                              List<DiscountResponseDto> appliedDiscounts, BigDecimal totalPrice) {

}