package com.mashasoftware.onlinebookstore.book.service;


import com.mashasoftware.onlinebookstore.book.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> getBooks();
}