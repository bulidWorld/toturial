package org.zwx.db.hbm.module_wuliu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tbl_client")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "bank_account_no")
    private String bankAcctNo;

    @Column(name = "tele_phone")
    private String telePhont;

    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    private boolean bLeaf;

    private boolean bClient;


}
