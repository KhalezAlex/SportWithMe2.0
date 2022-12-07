package com.swm.sportwithme.dao;

import com.swm.sportwithme.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDAO extends JpaRepository<Country, Long> {
    Country findByName(String countryName);
}
