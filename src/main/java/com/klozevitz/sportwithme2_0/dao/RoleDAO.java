package com.swm.sportwithme.dao;

import com.swm.sportwithme.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
}
