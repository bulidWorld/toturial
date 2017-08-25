package org.zwx.spring.stu.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class JudgeBean implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeDestruction" + o.getClass().getName());
        System.out.println("s:" + s);
    }

    @Override
    public boolean requiresDestruction(Object o) {
        System.out.println("requiresDestruction " + o.getClass().getName());
        return false;
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + s);
        System.out.println("postProcessBeforeInitialization " + o.getClass().getName());
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization " + s);
        System.out.println("postProcessAfterInitialization " + o.getClass().getName());
        return o;
    }
}
