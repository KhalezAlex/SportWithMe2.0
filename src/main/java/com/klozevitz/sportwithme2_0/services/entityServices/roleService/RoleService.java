package com.swm.sportwithme.services.entityServices.roleService;

import com.swm.sportwithme.model.Role;

public interface RoleService {
    void save(Long id, String name);
    Role getById(Long id);
}
