package com.swm.sportwithme.services.entityServices.cityService;

import com.swm.sportwithme.model.City;



//дописать ссылку на страну
public interface CityService {
    void save(String cityName, String countryName);
    City getByName(String name);

}
