package com.klozevitz.sportwithme2_0.model.dao;

import com.klozevitz.sportwithme2_0.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IUserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
