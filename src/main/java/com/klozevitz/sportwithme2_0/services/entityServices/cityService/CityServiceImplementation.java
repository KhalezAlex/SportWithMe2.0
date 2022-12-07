package com.swm.sportwithme.services.entityServices.cityService;

import com.swm.sportwithme.dao.CityDAO;
import com.swm.sportwithme.model.City;
import com.swm.sportwithme.services.entityServices.countryService.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImplementation implements CityService{
    @Autowired
    private CityDAO cityDAO;
    @Autowired
    private CountryService countryService;
    @Override
    public void save(String cityName, String countryName) {
        cityDAO.save(new City(cityName, countryService.getByName(countryName)));
    }

    @Override
    public City getByName(String name) {
        return null;
    }

    public City getById(Long id) {
        return cityDAO.findById(id).orElse(null);
    }
}
