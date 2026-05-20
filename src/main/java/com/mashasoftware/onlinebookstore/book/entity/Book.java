package com.mashasoftware.onlinebookstore.book.entity;

import com.mashasoftware.onlinebookstore.purchase.entity.Cart;
import com.mashasoftware.onlinebookstore.purchase.entity.Purchase;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

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

    @ManyToMany(mappedBy = "books")
    private List<Purchase> purchases;

    @ManyToMany(mappedBy = "books")
    private List<Cart> carts;

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

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}