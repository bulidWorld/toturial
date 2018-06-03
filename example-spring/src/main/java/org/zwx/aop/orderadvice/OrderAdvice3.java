package org.zwx.aop.orderadvice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.zwx.aop.LOG;
import org.zwx.aop.OrderAdvice;

@Aspect
@Component
@Order(OrderSeq.first)
public class OrderAdvice3 {


    @Before("@annotation(order)")
    public void before(OrderAdvice order) {
        System.out.println("before advice3............");
    }



}


