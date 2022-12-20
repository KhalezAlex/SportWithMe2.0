package com.klozevitz.sportwithme2_0.dao;

import com.klozevitz.sportwithme2_0.model.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDAO extends JpaRepository<Country, Long> {
    Country findByName(String countryName);
}
