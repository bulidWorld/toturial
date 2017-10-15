package org.zwx.ws.service.impl;

import org.springframework.stereotype.Service;
import org.zwx.ws.service.api.HumanResourceService;

import java.util.Date;

@Service
public class HumanResourceServiceImpl implements HumanResourceService{

    public void bookLeave(Date startDate, Date endDate, String name) {
        System.out.println(name + ":" + startDate + "----" + endDate);
    }
}
