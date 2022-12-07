package com.klozevitz.sportwithme2_0.dao;

import com.klozevitz.sportwithme2_0.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
