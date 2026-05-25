package com.mashasoftware.onlinebookstore.purchase.dto;

import com.mashasoftware.onlinebookstore.book.entity.Book;
import com.mashasoftware.onlinebookstore.purchase.entity.Discount;

import java.util.List;

public record CartResponseDto(Integer id, List<Book> books, List<Discount> offeredDiscounts,
                              List<Discount> appliedDiscounts) {

}