package org.zwx.db.hbm.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/5/4.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    private int age;

    private Long action_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getAction_id() {
        return action_id;
    }

    public Person(String name, int age, Long action_id) {
        this.name = name;
        this.age = age;
        this.action_id = action_id;
    }

    public Person() {
    }

    public void setAction_id(Long action_id) {
        this.action_id = action_id;
    }
}
