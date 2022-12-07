package com.klozevitz.sportwithme2_0.services.entityServices.roleService;

import com.klozevitz.sportwithme2_0.model.Role;

public interface RoleService {
    void save(Long id, String name);
    Role getById(Long id);
}
