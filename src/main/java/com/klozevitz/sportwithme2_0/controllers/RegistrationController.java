package com.klozevitz.sportwithme2_0.controllers;

import com.klozevitz.sportwithme2_0.model.User;
import com.klozevitz.sportwithme2_0.services.entityServices.userService.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private UserServiceImplementation userService;

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        if(!userService.save(new User(user.getUsername(), user.getPassword())))
            return "Epic fail";
        return "Ok";
    }
}
