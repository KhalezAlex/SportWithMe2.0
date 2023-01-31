package com.klozevitz.sportwithme2_0.services.entityServices.activityService;

import com.klozevitz.sportwithme2_0.model.dao.IActivityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    @Autowired
    private IActivityDAO iActivityDAO;
}
