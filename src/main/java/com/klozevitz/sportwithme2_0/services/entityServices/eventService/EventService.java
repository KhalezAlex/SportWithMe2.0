package com.klozevitz.sportwithme2_0.services.entityServices.eventService;

import com.klozevitz.sportwithme2_0.model.dao.IEventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private IEventDAO eventDAO;
}
