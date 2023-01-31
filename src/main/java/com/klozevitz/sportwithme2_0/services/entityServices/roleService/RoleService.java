package com.klozevitz.sportwithme2_0.services.entityServices.roleService;

import com.klozevitz.sportwithme2_0.model.dao.IRoleDAO;
import com.klozevitz.sportwithme2_0.model.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private IRoleDAO roleDAO;

    public void save(Long id, String name) {
        roleDAO.save(new Role(id, name));
    }

    public Role getById(Long id) {
        return roleDAO.findById(id).orElse(null);
    }
}
