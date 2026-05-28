package com.mashasoftware.onlinebookstore.purchase.repository;

import com.mashasoftware.onlinebookstore.purchase.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}