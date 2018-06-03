package org.zwx.service.api;

import org.zwx.entity.User;

public interface PrivilegeService
{
    boolean hasPrivilege(User user);

}
