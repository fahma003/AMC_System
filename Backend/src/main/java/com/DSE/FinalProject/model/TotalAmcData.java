package com.DSE.FinalProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "total_amc_data")
public class TotalAmcData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amcID;

    @Column(name= "month")
    private String month;

    @Column (name="count")
    private Integer count;

    public Long getAmcID() {
        return amcID;
    }

    public void setAmcID(Long amcID) {
        this.amcID = amcID;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
