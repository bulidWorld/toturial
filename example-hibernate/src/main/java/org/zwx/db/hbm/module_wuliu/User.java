package org.zwx.db.hbm.module_wuliu;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String email;

    private String telephone;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name="flow_card")
    @OneToMany
    private Set<FlowCard> flowCardSet;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
