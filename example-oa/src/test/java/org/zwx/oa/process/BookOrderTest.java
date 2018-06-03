package org.zwx.oa.process;


import com.google.common.collect.Maps;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:allCfg.xml")
public class BookOrderTest {

    @Autowired
    private RuntimeService runtimeService;


    @Autowired
    private TaskService taskService;

    private Task task;


    @Test
    public void testQueryByInstanceId() {

        //有什么区别？？
        String instanceId = startOrderBookProcess().getId();
        //getInstanceId 与 getId
//        startOrderBookProcess().getProcessInstanceId();
        Task task = null;
        task = taskService.createTaskQuery().processInstanceId(instanceId).singleResult();
        taskService.complete(task.getId());

    }


    private ProcessInstance startOrderBookProcess(){
        Map<String, Object> map = Maps.newHashMap();
        map.put("isbn", "123445");
        return runtimeService.startProcessInstanceByKey("bookorder", map);
    }


    @Test
    public void testProcess() {

        Map<String, Object> map = Maps.newHashMap();
        map.put("var1", "val1");
        map.put("time", new Date());
        Map<String, Object> data = Maps.newHashMap();
        data.put("requestMap", map);
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("test1", data);
        Task task = taskService.createTaskQuery().processInstanceId(instance.getId()).singleResult();


//        task.forEach(t -> System.out.println(t.getName()));

        taskService.claim(task.getId(), "zwx5");
//        taskService.claim(task.getId(), "zwx1");
//        taskService.complete(task.getId());
//        taskService.setAssignee(task.getId(), "zwx3");
//        taskService.setAssignee(task.getId(), "zwx4");
//        taskService.setAssignee(task.getId(), "zwx5");

    }



    @Test
    public void getTaskTest() {

        task = taskService.createTaskQuery().taskAssignee("zwx5").singleResult();
        taskService.complete(task.getId());
        System.out.println(task.getId());

    }

    @Test
    public void getSelfCreateTask() {



    }




}
