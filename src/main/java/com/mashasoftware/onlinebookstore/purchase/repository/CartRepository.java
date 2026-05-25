package com.mashasoftware.onlinebookstore.purchase.repository;

import com.mashasoftware.onlinebookstore.purchase.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findByUserId(Integer userId);
}