package com.mashasoftware.onlinebookstore.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints = 0;

    public User() {
    }

    public User(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}