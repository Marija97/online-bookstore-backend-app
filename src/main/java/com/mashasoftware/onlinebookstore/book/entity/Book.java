package com.mashasoftware.onlinebookstore.book.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    private BookType type;

    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;

    @Column(nullable = false)
    private Integer quantity;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BookType getType() {
        return type;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

}