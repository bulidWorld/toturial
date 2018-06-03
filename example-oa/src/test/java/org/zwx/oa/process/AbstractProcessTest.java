package org.zwx.oa.process;


import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:allCfg.xml")
public abstract class AbstractProcessTest {

    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected TaskService taskService;


    protected ProcessInstance startInstance(String id) {
        return runtimeService.startProcessInstanceByKey(id);
    }

}
