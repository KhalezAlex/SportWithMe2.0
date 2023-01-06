package com.klozevitz.sportwithme2_0.utilities;

import com.klozevitz.sportwithme2_0.model.entities.User;
import com.klozevitz.sportwithme2_0.services.entityServices.cityService.CityService;
import com.klozevitz.sportwithme2_0.services.entityServices.countryService.CountryService;
import com.klozevitz.sportwithme2_0.services.entityServices.roleService.RoleService;
import com.klozevitz.sportwithme2_0.services.entityServices.userService.UserService;

public class TablesInit {
    public static void tablesInit(RoleService rs, UserService us, CountryService cos, CityService cis) {
        rolesTableInit(rs);
        adminInit(us);
        countryTableInit(cos);
        cityTableInit(cis);
    }

    private static void rolesTableInit(RoleService roleService) {
        if (roleService.getById(1L) == null){
            roleService.save(1L, "ROLE_ADMIN");
            roleService.save(2L, "ROLE_USER");
            roleService.save(3L, "ROLE_STRIKED");
        }
    }

    private static void countryTableInit(CountryService countryService){
        if(countryService.getById(1L) == null)
            countryService.save("Россия");
    }

    private static void cityTableInit(CityService cityService) {
        String[] russianCities = {"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань",
                "Нижний Новгород", "Челябинск", "Красноярск", "Самара", "Уфа", "Ростов на Дону", "Омск", "Краснодар",
                "Воронеж", "Пермь", "Волгоград"};
        if (cityService.getById(1L) == null)
            for (String city : russianCities)
                cityService.save(city, "Россия");
    }


    public static void adminInit(UserService userService) {
        if (userService.findByUsername("admin") == null) {
            userService.save(new User("admin", "admin"), 1L);
            userService.save(new User("user", "user"), 2L);
            userService.save(new User("loser", "loser"), 3L);
        }
    }
}