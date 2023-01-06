package com.klozevitz.sportwithme2_0.controllers;

import com.klozevitz.sportwithme2_0.model.dao.ICityDAO;
import com.klozevitz.sportwithme2_0.model.dao.ICountryDAO;
import com.klozevitz.sportwithme2_0.model.entities.City;
import com.klozevitz.sportwithme2_0.model.entities.Country;
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
    ICityDAO ICityDAO;
    @Autowired
    ICountryDAO ICountryDAO;

    @GetMapping("/loadCitiesCountries")
    public String loadCitiesCountries() {
        return getJson(getDTO());
    }

    private Map<String, List<String>> getDTO() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("countries", getCountries());
        map.put("cities", getCities());
        return map;
    }

    private List<String> getCities() {
        List<String> cities = new LinkedList<>();
        for (City city: ICityDAO.findAll())
            cities.add(city.getName());
        return cities;
    }

    private List<String> getCountries() {
        List<String> countries = new LinkedList<>();
        for (Country country: ICountryDAO.findAll())
            countries.add(country.getName());
        return countries;
    }
}
