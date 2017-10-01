package org.zwx.db.hbm.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Action {

    @Id
    @GeneratedValue()
    private Long id;

    private String name;

    private String desction;

    private String type;

    private String condi;

    public Action(String name, String desction, String type, String condi) {
        this.name = name;
        this.desction = desction;
        this.type = type;
        this.condi = condi;
    }

    public Action() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesction() {
        return desction;
    }

    public void setDesction(String desction) {
        this.desction = desction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondi() {
        return condi;
    }

    public void setCondi(String condi) {
        this.condi = condi;
    }
}
