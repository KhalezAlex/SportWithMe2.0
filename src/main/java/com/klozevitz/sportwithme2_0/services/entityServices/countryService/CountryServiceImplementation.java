package com.swm.sportwithme.services.entityServices.countryService;

import com.swm.sportwithme.model.Country;
import com.swm.sportwithme.dao.CountryDAO;
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
