package com.klozevitz.sportwithme2_0.services.entityServices.userService;

import com.klozevitz.sportwithme2_0.model.User;

public interface UserService {
    boolean save(User user);
    boolean save(User user, Long roleId);
    boolean update(User user, String username);
    User findByUsername(String username);
}
