package com.mashasoftware.onlinebookstore.purchase.entity;

import com.mashasoftware.onlinebookstore.book.entity.Book;
import com.mashasoftware.onlinebookstore.user.entity.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private List<Discount> offeredDiscounts = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "applied_discounts", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "discount_id"))
    private List<Discount> appliedDiscounts = new ArrayList<>();

    public Cart() {
    }

    public Integer addABook(Book book) {
        books.add(book);

        // Todo check loyalty points!
        var discountId = Discount.getDiscountIdForBook(book.getType());
        if (offeredDiscounts.stream().noneMatch((discount -> Objects.equals(discount.getId(), discountId)))) {
            return discountId;
        }
        return null;
    }

    public void offerADiscount(Discount discount) {
        this.offeredDiscounts.add(discount);
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