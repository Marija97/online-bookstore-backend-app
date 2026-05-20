package com.mashasoftware.onlinebookstore.book.controller;

import com.mashasoftware.onlinebookstore.book.dto.BookResponseDto;
import com.mashasoftware.onlinebookstore.book.entity.BookType;
import com.mashasoftware.onlinebookstore.book.service.BookService;
import com.mashasoftware.onlinebookstore.user.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<BookResponseDto> getBooks() {
        return bookService.getBooks();
    }
}
