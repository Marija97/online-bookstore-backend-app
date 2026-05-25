package com.mashasoftware.onlinebookstore.purchase.entity;

import com.mashasoftware.onlinebookstore.book.entity.Book;
import com.mashasoftware.onlinebookstore.user.entity.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "carts_books", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "offered_discounts", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "discount_id"))
    private List<Discount> offeredDiscounts;

    @ManyToMany
    @JoinTable(name = "applied_discounts", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "discount_id"))
    private List<Discount> appliedDiscounts;

    public Cart() {
    }

    public void addABook(Book book) {
        books.add(book);
    }

    private void addDiscount(Discount discount) {

    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return this.id;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public List<Discount> getOfferedDiscounts() {
        return this.offeredDiscounts;
    }

    public List<Discount> getAppliedDiscounts() {
        return this.appliedDiscounts;
    }
}