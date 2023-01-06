package com.klozevitz.sportwithme2_0.controllers;

import com.klozevitz.sportwithme2_0.model.entities.User;
import com.klozevitz.sportwithme2_0.services.entityServices.cityService.CityService;
import com.klozevitz.sportwithme2_0.services.entityServices.userService.UserService;
import com.klozevitz.sportwithme2_0.services.securityService.SecurityServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityServiceImplementation securityService;

    @Autowired
    private CityService cityService;

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        if (!userService.save(new User(user.getUsername(), user.getPassword())))
            return "registration failed";
        return "registered";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        if (!securityService.login(user.getUsername(), user.getPassword()))
            return "login failed";
        return "login success";
    }

    @Transactional
    @GetMapping("/updateProfile")
    public String updateProfile(@ModelAttribute User userChanges, @RequestParam String cityName) {
        userChanges.setCity(cityService.getByName(cityName));
        updateUser(userChanges);
        return "cool";
    }

    private void updateUser(User userChanges) {
        User user = userService.findByUsername(userChanges.getUsername());
        user.setName(userChanges.getName());
        user.setAge(userChanges.getAge());
        user.setPhone(userChanges.getPhone());
        user.setCity(userChanges.getCity());
    }
}
