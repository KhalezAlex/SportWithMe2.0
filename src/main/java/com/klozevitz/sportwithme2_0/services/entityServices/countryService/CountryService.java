package com.klozevitz.sportwithme2_0.services.entityServices.countryService;

import com.klozevitz.sportwithme2_0.model.dao.ICountryDAO;
import com.klozevitz.sportwithme2_0.model.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    ICountryDAO countryDAO;

    public void save(String name) {
        countryDAO.save(new Country(name));
    }

    public Country getByName(String countryName) {
        return countryDAO.findByName(countryName);
    }

    public Country getById(Long id) {
        return countryDAO.findById(id).orElse(null);
    }
}
