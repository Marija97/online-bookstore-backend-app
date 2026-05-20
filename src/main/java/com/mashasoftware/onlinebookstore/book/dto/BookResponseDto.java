package com.mashasoftware.onlinebookstore.book.dto;

import com.mashasoftware.onlinebookstore.book.entity.BookType;

import java.math.BigDecimal;

public record BookResponseDto(Integer id, String title, BookType bookType, BigDecimal basePrice) {

}