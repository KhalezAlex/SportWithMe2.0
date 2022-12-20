package com.klozevitz.sportwithme2_0.services.entityServices.userService;

import com.klozevitz.sportwithme2_0.dao.RoleDAO;
import com.klozevitz.sportwithme2_0.dao.UserDAO;
import com.klozevitz.sportwithme2_0.model.entities.Role;
import com.klozevitz.sportwithme2_0.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public boolean save(User user) {
        if (userDAO.findByUsername(user.getUsername()) != null)
            return false;
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(2L));
        user.setRoles(roles);
        userDAO.save(user);
        return true;
    }

    @Override
    @Transactional
    public boolean save(User user, Long roleId) {
        if (userDAO.findByUsername(user.getUsername()) != null)
            return false;
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(roleId));
        user.setRoles(roles);
        userDAO.save(user);
        return true;
    }

    @Override
    public boolean update(User user, String username) {
        if (userDAO.findByUsername(username) != null)
            user = null;
        return true;
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public boolean checkLogin(String username) {
        return userDAO.findByUsername(username)!= null;
    }
}
