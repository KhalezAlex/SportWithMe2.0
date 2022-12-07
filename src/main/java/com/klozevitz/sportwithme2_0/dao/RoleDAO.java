package com.klozevitz.sportwithme2_0.dao;

import com.klozevitz.sportwithme2_0.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
}
