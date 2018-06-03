package org.zwx.spring.stu.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;
import org.zwx.aop.SimpleService;

@Component
public class BeanFactoryAwareImpl implements BeanFactoryAware {

    private BeanFactory beanFactory;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        this.beanFactory = beanFactory;
    }

    public void doSth()
    {
        beanFactory.getBean(SimpleService.class).doSth();
    }

}
