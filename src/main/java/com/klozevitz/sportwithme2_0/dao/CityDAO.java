package com.swm.sportwithme.dao;

import com.swm.sportwithme.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDAO extends JpaRepository<City, Long> {
     City getByName(String name);
}
