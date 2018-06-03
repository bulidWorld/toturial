package org.zwx.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwx.base.dao.PersonDao;
import org.zwx.base.entity.Person;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public Person getPerson(Long id) {
        Person person = personDao.findOne(id);
        return person;
    }

    public void save(Integer age, String name) {
        Person person = new Person();
        person.setAge(age);
        person.setName(name);
        Person savedPerson = personDao.save(person);
    }
}
