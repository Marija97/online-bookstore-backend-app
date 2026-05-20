package com.mashasoftware.onlinebookstore.user.repository;

import com.mashasoftware.onlinebookstore.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}