package com.klozevitz.sportwithme2_0.model.dao;

import com.klozevitz.sportwithme2_0.model.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventDAO extends JpaRepository<Event, Long> {
}
