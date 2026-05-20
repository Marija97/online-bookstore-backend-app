package com.mashasoftware.onlinebookstore.book.repository;

import com.mashasoftware.onlinebookstore.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
}