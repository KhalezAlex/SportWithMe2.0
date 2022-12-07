package com.klozevitz.sportwithme2_0.services.entityServices.countryService;

import com.klozevitz.sportwithme2_0.dao.CountryDAO;
import com.klozevitz.sportwithme2_0.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImplementation implements CountryService{
    @Autowired
    CountryDAO countryDAO;

    @Override
    public void save(String name) {
        countryDAO.save(new Country(name));
    }

    @Override
    public Country getByName(String countryName) {
        return countryDAO.findByName(countryName);
    }

    @Override
    public Country getById(Long id) {
        return countryDAO.findById(id).orElse(null);
    }

}
