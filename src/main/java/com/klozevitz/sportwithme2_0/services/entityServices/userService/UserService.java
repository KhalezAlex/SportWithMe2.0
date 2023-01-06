package com.klozevitz.sportwithme2_0.services.entityServices.userService;

import com.klozevitz.sportwithme2_0.model.dao.IRoleDAO;
import com.klozevitz.sportwithme2_0.model.dao.IUserDAO;
import com.klozevitz.sportwithme2_0.model.entities.Role;
import com.klozevitz.sportwithme2_0.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    IUserDAO IUserDAO;
    @Autowired
    IRoleDAO IRoleDAO;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Transactional
    public boolean save(User user) {
        if (IUserDAO.findByUsername(user.getUsername()) != null)
            return false;
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(IRoleDAO.getOne(2L));
        user.setRoles(roles);
        IUserDAO.save(user);
        return true;
    }

    @Transactional
    public boolean save(User user, Long roleId) {
        if (IUserDAO.findByUsername(user.getUsername()) != null)
            return false;
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(IRoleDAO.getOne(roleId));
        user.setRoles(roles);
        IUserDAO.save(user);
        return true;
    }

    public boolean update(User user, String username) {
        if (IUserDAO.findByUsername(username) != null)
            user = null;
        return true;
    }

    public User findByUsername(String username) {
        return IUserDAO.findByUsername(username);
    }

    public boolean checkLogin(String username) {
        return IUserDAO.findByUsername(username)!= null;
    }
}
