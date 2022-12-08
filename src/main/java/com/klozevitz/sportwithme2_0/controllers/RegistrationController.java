package com.klozevitz.sportwithme2_0.controllers;

import com.klozevitz.sportwithme2_0.model.User;
import com.klozevitz.sportwithme2_0.services.entityServices.userService.UserServiceImplementation;
import com.klozevitz.sportwithme2_0.services.securityService.SecurityServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private UserServiceImplementation userService;
    @Autowired
    private SecurityServiceImplementation securityService;

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        if(!userService.save(new User(user.getUsername(), user.getPassword())))
            return "registration failed";
        return "registered";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user){
        if (!securityService.login(user.getUsername(), user.getPassword()))
            return "login failed";
        return "login success";
    }
}
