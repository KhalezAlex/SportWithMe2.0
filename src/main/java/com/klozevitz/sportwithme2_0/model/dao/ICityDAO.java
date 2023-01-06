package com.klozevitz.sportwithme2_0.model.dao;


import com.klozevitz.sportwithme2_0.model.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityDAO extends JpaRepository<City, Long> {
     City getByName(String name);
}
