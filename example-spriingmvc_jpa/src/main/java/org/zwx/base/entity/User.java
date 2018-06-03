package org.zwx.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;


    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_PWD")
    private String password;

    @Column(name = "REG_DATE")
    private Date registerDate;

    @ManyToOne
    @JoinColumn(name = "GTOUP_ID")
    @JsonIgnore
    private Group group;

    @Column(name = "LOCKED")
    private Integer locked;

    @Column(name = "USER_SALT")
    private String salt;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
