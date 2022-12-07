package com.swm.sportwithme.utilities;

import com.swm.sportwithme.model.User;
import com.swm.sportwithme.services.entityServices.cityService.CityServiceImplementation;
import com.swm.sportwithme.services.entityServices.countryService.CountryServiceImplementation;
import com.swm.sportwithme.services.entityServices.roleService.RoleServiceImplementation;
import com.swm.sportwithme.services.entityServices.userService.UserServiceImplementation;

public class TablesInit {
    public static void rolesTableInit(RoleServiceImplementation roleService) {
        if (roleService.getById(1L) == null){
            roleService.save(1L, "ROLE_ADMIN");
            roleService.save(2L, "ROLE_USER");
            roleService.save(3L, "ROLE_STRIKED");
        }
    }

    public static void countryTableInit(CountryServiceImplementation countryService){
        if(countryService.getById(1L) == null)
            countryService.save("Россия");
    }
    public static void cityTableInit(CityServiceImplementation cityService) {
        String[] russianCities = {"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань",
                "Нижний Новгород", "Челябинск", "Красноярск", "Самара", "Уфа", "Ростов на Дону", "Омск", "Краснодар",
                "Воронеж", "Пермь", "Волгоград"};
        if (cityService.getById(1L) == null) {
            for (String city : russianCities)
                cityService.save(city, "Россия");
        }
    }


    public static void adminInit(UserServiceImplementation userServiceImplementation) {
        if (userServiceImplementation.findByUsername("admin") == null) {
            User user = new User("admin", "admin");
            userServiceImplementation.save(user, 1L);
        }
    }
}