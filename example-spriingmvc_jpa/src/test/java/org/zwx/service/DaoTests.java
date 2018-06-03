package org.zwx.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zwx.base.dao.GroupDao;
import org.zwx.base.entity.Group;
import org.zwx.base.entity.Person;
import org.zwx.base.entity.User;
import org.zwx.base.service.PersonService;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DaoTests {

    @Autowired
    PersonService personService;

    @Autowired
    GroupDao groupDao;
    @Test
    public void save(){
        personService.save(10, "zwx_2");
    }

    @Test
    public void get() {
        Person person = personService.getPerson(2L);
        Assert.assertEquals("zwx_2", person.getName());
    }


    @Test
    public void getGroup() {
        Group group = groupDao.findOne(1);
        Set<User> userSet = group.getUsers();
        Assert.assertNotEquals(0, userSet.size());
        Assert.assertNotNull(group);
    }
}
