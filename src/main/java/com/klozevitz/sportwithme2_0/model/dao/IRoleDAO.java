package com.klozevitz.sportwithme2_0.model.dao;

import com.klozevitz.sportwithme2_0.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDAO extends JpaRepository<Role, Long> {
}
