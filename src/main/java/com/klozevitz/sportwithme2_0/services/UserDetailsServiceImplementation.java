package com.klozevitz.sportwithme2_0.services;

import com.klozevitz.sportwithme2_0.model.dao.IUserDAO;
import com.klozevitz.sportwithme2_0.model.entities.Role;
import com.klozevitz.sportwithme2_0.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    IUserDAO IUserDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = IUserDAO.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role: user.getRoles())
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), grantedAuthorities);
    }
}
