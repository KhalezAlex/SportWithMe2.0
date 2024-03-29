package com.klozevitz.sportwithme2_0.services.entityServices.cityService;

import com.klozevitz.sportwithme2_0.model.dao.ICityDAO;
import com.klozevitz.sportwithme2_0.model.entities.City;
import com.klozevitz.sportwithme2_0.services.entityServices.countryService.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private ICityDAO cityDAO;
    @Autowired
    private CountryService countryService;

    public void save(String cityName, String countryName) {
        cityDAO.save(new City(cityName, countryService.getByName(countryName)));
    }

    public City getByName(String name) {
        return cityDAO.getByName(name);
    }

    public City getById(Long id) {
        return cityDAO.findById(id).orElse(null);
    }
}
