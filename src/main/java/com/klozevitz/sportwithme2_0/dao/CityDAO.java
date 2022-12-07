package com.klozevitz.sportwithme2_0.dao;


import com.klozevitz.sportwithme2_0.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDAO extends JpaRepository<City, Long> {
     City getByName(String name);
}
