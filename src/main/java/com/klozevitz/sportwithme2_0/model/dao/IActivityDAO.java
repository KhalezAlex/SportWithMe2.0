package com.klozevitz.sportwithme2_0.model.dao;

import com.klozevitz.sportwithme2_0.model.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActivityDAO extends JpaRepository<Activity, Long> {

}
