package com.klozevitz.sportwithme2_0.services.entityServices.roleService;

import com.klozevitz.sportwithme2_0.dao.RoleDAO;
import com.klozevitz.sportwithme2_0.model.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation  implements RoleService{
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public void save(Long id, String name) {
        roleDAO.save(new Role(id, name));
    }

    @Override
    public Role getById(Long id) {
        return roleDAO.findById(id).orElse(null);
    }
}
