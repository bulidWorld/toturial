package org.zwx.db.hbm.module_wuliu;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tbl_flow_card")
public class FlowCard {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="card_no")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String cardNo;

    @Column(name="opt_type")
    private String optType;

    @Column(name="opt_date")
    private Date optDate;

    private Integer status;

    @Column(name="adjust_date")
    private Date adjustDate;

    @Column(name="spot_date")
    private Date spotDate;

    @Column(name = "spot_desc")
    private String spotDesc;

    @Column(name = "confirm_date")
    private Date confirmDate;

    @ManyToOne
    private FiscalYearPeriod fiscalYearPeriod;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public Date getOptDate() {
        return optDate;
    }

    public void setOptDate(Date optDate) {
        this.optDate = optDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }

    public Date getSpotDate() {
        return spotDate;
    }

    public void setSpotDate(Date spotDate) {
        this.spotDate = spotDate;
    }

    public String getSpotDesc() {
        return spotDesc;
    }

    public void setSpotDesc(String spotDesc) {
        this.spotDesc = spotDesc;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }
}
