package com.klozevitz.sportwithme2_0.controllers;

import com.klozevitz.sportwithme2_0.dao.CityDAO;
import com.klozevitz.sportwithme2_0.dao.CountryDAO;
import com.klozevitz.sportwithme2_0.model.entities.City;
import com.klozevitz.sportwithme2_0.model.entities.Country;
import com.klozevitz.sportwithme2_0.services.entityServices.cityService.CityServiceImplementation;
import com.klozevitz.sportwithme2_0.services.entityServices.countryService.CountryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.klozevitz.sportwithme2_0.utilities.RestControllersUtilities.getJson;

@RestController
public class LoadCitiesCountriesController {
    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryDAO countryDAO;

    @GetMapping("/loadCitiesCountries")
    public String loadCitiesCountries() {
        List<String> cities = new LinkedList<>();
        for (City city: cityDAO.findAll())
            cities.add(city.getName());
        List<String> countries = new LinkedList<>();
        for (Country country: countryDAO.findAll())
            countries.add(country.getName());
        Map<String, List<String>> map = new HashMap<>();
        map.put("countries", countries);
        map.put("cities", cities);
        return getJson(map);
    }
}
