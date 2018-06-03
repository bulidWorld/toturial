package org.zwx.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zwx.entity.User;
import org.zwx.service.api.PrivilegeService;

public class SimplePrivilegeServiceImpl implements PrivilegeService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SimplePrivilegeServiceImpl.class);

    @Override
    public boolean hasPrivilege(User user) {
        LOGGER.info("{} need check privilege!!!", user.getName());
        System.out.println(user.getName() + "is check privilege");
        return true;
    }
}
