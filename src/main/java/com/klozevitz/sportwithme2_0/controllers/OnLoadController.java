package com.klozevitz.sportwithme2_0.controllers;

import com.klozevitz.sportwithme2_0.model.dto.UserDTO;
import com.klozevitz.sportwithme2_0.services.entityServices.cityService.CityService;
import com.klozevitz.sportwithme2_0.services.entityServices.countryService.CountryService;
import com.klozevitz.sportwithme2_0.services.entityServices.roleService.RoleService;
import com.klozevitz.sportwithme2_0.services.entityServices.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.klozevitz.sportwithme2_0.utilities.RestControllersUtilities.getJson;

@RestController
public class OnLoadController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    CountryService countryService;
    @Autowired
    CityService cityService;

    @GetMapping("/onLoad")
    public String onLoad() {
//        tablesInit(roleService, userService, countryService, cityService);
        return getJson(getRegisteredUserDto());
    }

    private Map<String, UserDTO> getRegisteredUserDto() {
        Map<String, UserDTO> map = new HashMap<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username.equals("anonymousUser"))
            map.put("user", null);
        else
            map.put("user", new UserDTO(userService.findByUsername(username)));
        return map;
    }
}