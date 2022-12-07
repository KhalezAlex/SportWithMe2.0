package com.klozevitz.sportwithme2_0.services.entityServices.cityService;


import com.klozevitz.sportwithme2_0.model.City;

//дописать ссылку на страну
public interface CityService {
    void save(String cityName, String countryName);
    City getByName(String name);

}
