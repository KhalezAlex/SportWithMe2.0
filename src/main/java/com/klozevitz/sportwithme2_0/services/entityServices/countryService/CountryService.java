package com.klozevitz.sportwithme2_0.services.entityServices.countryService;


import com.klozevitz.sportwithme2_0.model.Country;

public interface CountryService {
//    void save(Long id, String name);
void save(String name);
    Country getByName(String countryName);
    Country getById(Long id);
}
