package com.klozevitz.sportwithme2_0.services.entityServices.roleService;

import com.klozevitz.sportwithme2_0.model.dao.IRoleDAO;
import com.klozevitz.sportwithme2_0.model.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private IRoleDAO IRoleDAO;

    public void save(Long id, String name) {
        IRoleDAO.save(new Role(id, name));
    }

    public Role getById(Long id) {
        return IRoleDAO.findById(id).orElse(null);
    }
}
