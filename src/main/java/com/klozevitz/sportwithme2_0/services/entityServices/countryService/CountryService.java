package com.klozevitz.sportwithme2_0.services.entityServices.countryService;

import com.klozevitz.sportwithme2_0.model.dao.ICountryDAO;
import com.klozevitz.sportwithme2_0.model.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    ICountryDAO ICountryDAO;

    public void save(String name) {
        ICountryDAO.save(new Country(name));
    }

    public Country getByName(String countryName) {
        return ICountryDAO.findByName(countryName);
    }

    public Country getById(Long id) {
        return ICountryDAO.findById(id).orElse(null);
    }
}
