package com.swm.sportwithme.dao;

import com.swm.sportwithme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
