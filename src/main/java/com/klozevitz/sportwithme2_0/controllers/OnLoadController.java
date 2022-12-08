package com.klozevitz.sportwithme2_0.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.klozevitz.sportwithme2_0.services.entityServices.cityService.CityServiceImplementation;
import com.klozevitz.sportwithme2_0.services.entityServices.countryService.CountryServiceImplementation;
import com.klozevitz.sportwithme2_0.services.entityServices.roleService.RoleServiceImplementation;
import com.klozevitz.sportwithme2_0.services.entityServices.userService.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.klozevitz.sportwithme2_0.utilities.TablesInit.*;

@RestController
public class OnLoadController {
    @Autowired
    RoleServiceImplementation roleService;
    @Autowired
    UserServiceImplementation userServiceImplementation;
    @Autowired
    CountryServiceImplementation countryServiceImplementation;
    @Autowired
    CityServiceImplementation cityServiceImplementation;

    @GetMapping("/onLoad")
    public String onLoad() {
        rolesTableInit(roleService);
        adminInit(userServiceImplementation);
        countryTableInit(countryServiceImplementation);
        cityTableInit(cityServiceImplementation);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<String, String> set = new HashMap<>();
        set.put("username", auth.getName());
        set.put("auth", auth.getAuthorities().toString());

        return getJson(set);
    }

    private String getJson(Object resp) {
        GsonBuilder builder = new GsonBuilder();
        Gson response = builder.create();
        return response.toJson(resp);
    }
}