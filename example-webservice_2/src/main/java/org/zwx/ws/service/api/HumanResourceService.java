package org.zwx.ws.service.api;

import java.util.Date;

public interface HumanResourceService {
    void bookLeave(Date startDate, Date endDate, String name);
}
