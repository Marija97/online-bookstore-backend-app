package com.mashasoftware.onlinebookstore.purchase.entity;

import com.mashasoftware.onlinebookstore.book.entity.BookType;
import com.mashasoftware.onlinebookstore.purchase.dto.DiscountResponseDto;
import jakarta.persistence.*;


@Entity
@Table(name = "discounts")
public class Discount {

    public static Integer forRegularBooksId = 1;
    public static Integer forOldBooksId = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_type", nullable = false, length = 3)
    private BookType bookType;

    @Column(name = "loyalty_points_cost", nullable = false)
    private Integer loyaltyPointsCost;

    @Column(name = "discount_percent", nullable = false)
    private Integer discountPercent;

    public Discount() {
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getLoyaltyPointsCost() {
        return this.loyaltyPointsCost;
    }

    public Integer getDiscountPercent() {
        return this.discountPercent;
    }

    static Integer getDiscountIdForBook(BookType bookType) {
        if (bookType == BookType.REG) return forRegularBooksId;
        if (bookType == BookType.OLD) return forOldBooksId;
        return null;
    }

    public DiscountResponseDto mapToDiscountResponseDto () {
        return new DiscountResponseDto(this.getId(), this.getLoyaltyPointsCost(), this.getDiscountPercent());
    }
}