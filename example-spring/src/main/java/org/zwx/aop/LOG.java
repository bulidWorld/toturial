package org.zwx.aop;

import org.zwx.service.api.PrivilegeService;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LOG {

    Class<? extends PrivilegeService> privilegeService();
}
