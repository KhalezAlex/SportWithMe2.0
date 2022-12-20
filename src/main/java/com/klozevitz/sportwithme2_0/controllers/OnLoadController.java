package com.klozevitz.sportwithme2_0.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.klozevitz.sportwithme2_0.model.dto.UserDTO;
import com.klozevitz.sportwithme2_0.services.entityServices.cityService.CityServiceImplementation;
import com.klozevitz.sportwithme2_0.services.entityServices.countryService.CountryServiceImplementation;
import com.klozevitz.sportwithme2_0.services.entityServices.roleService.RoleServiceImplementation;
import com.klozevitz.sportwithme2_0.services.entityServices.userService.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, UserDTO> map = new HashMap<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals("anonymousUser"))
            map.put("user", null);
        else
            map.put("user", new UserDTO(userServiceImplementation.findByUsername(username)));
        return getJson(map);
    }


    private String getJson(Object resp) {
        GsonBuilder builder = new GsonBuilder();
        Gson response = builder.create();
        return response.toJson(resp);
    }
}