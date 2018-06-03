package org.zwx.oa.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.runtime.Execution;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class TestService {


    public void doService(DelegateTask task, String eventName, DelegateExecution execution) {
        execution.setVariable("added", "addedVal");
        System.out.println(eventName);
        System.out.println(task.getDueDate());
    }

    public void testExecution(DelegateTask task, DelegateExecution execution, Date time) {
        System.out.println(time.toInstant().toString());
        System.out.println(execution.getVariables());
    }

    public void doService(Map<String, Object> requestMap) {
        System.out.println(requestMap);
    }

    public void helloActiviti(){
        System.out.println("hello activiti service!!!");
    }
}
