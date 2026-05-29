package com.mashasoftware.onlinebookstore.book.service.impl;

import com.mashasoftware.onlinebookstore.book.dto.BookResponseDto;
import com.mashasoftware.onlinebookstore.book.entity.Book;
import com.mashasoftware.onlinebookstore.book.repository.BookRepository;
import com.mashasoftware.onlinebookstore.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponseDto> getBooks() {
        // todo filter by quantity > 0 ...
        return bookRepository.findAll().stream().map(Book::mapToBookResponseDto).toList();
    }
}