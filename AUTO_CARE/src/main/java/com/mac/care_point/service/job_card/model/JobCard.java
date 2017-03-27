/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.service.job_card.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mac.care_point.service.job_item.model.TJobItem;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kavish Manjitha
 */
@Entity
@Table(name = "t_job_card")
@XmlRootElement
public class JobCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_no")
    private Integer indexNo;

    @Column(name = "number")
    private Integer number;

    @Column(name = "branch")
    private Integer branch;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "transaction")
    private Integer transaction;

    @Column(name = "price_category")
    private Integer priceCategory;

    @Column(name = "in_time")
    private String inTime;

    @Column(name = "out_time")
    private String outTime;

    @Column(name = "in_mileage")
    private Integer inMileage;

    @Column(name = "next_mileage")
    private Integer nextMileage;

    @Size(max = 25)
    @Column(name = "status")
    private String status;

    @Column(name = "bay")
    private Integer bay;

    @Column(name = "client")
    private Integer client;

    @Column(name = "vehicle")
    private Integer vehicle;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobCard", fetch = FetchType.EAGER)
    private List<TJobItem> tJobItemList;

    public JobCard() {
    }

    public JobCard(Integer indexNo, Integer number, Integer branch, Date date, Integer transaction, Integer priceCategory, String inTime, String outTime, Integer inMileage, Integer nextMileage, String status, Integer bay, Integer client, Integer vehicle, List<TJobItem> tJobItemList) {
        this.indexNo = indexNo;
        this.number = number;
        this.branch = branch;
        this.date = date;
        this.transaction = transaction;
        this.priceCategory = priceCategory;
        this.inTime = inTime;
        this.outTime = outTime;
        this.inMileage = inMileage;
        this.nextMileage = nextMileage;
        this.status = status;
        this.bay = bay;
        this.client = client;
        this.vehicle = vehicle;
        this.tJobItemList = tJobItemList;
    }

    public JobCard(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBranch() {
        return branch;
    }

    public void setBranch(Integer branch) {
        this.branch = branch;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTransaction() {
        return transaction;
    }

    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
    }

    public Integer getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(Integer priceCategory) {
        this.priceCategory = priceCategory;
    }

    public Integer getInMileage() {
        return inMileage;
    }

    public void setInMileage(Integer inMileage) {
        this.inMileage = inMileage;
    }

    public Integer getNextMileage() {
        return nextMileage;
    }

    public void setNextMileage(Integer nextMileage) {
        this.nextMileage = nextMileage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBay() {
        return bay;
    }

    public void setBay(Integer bay) {
        this.bay = bay;
    }

    public List<TJobItem> gettJobItemList() {
        return tJobItemList;
    }

    public void settJobItemList(List<TJobItem> tJobItemList) {
        this.tJobItemList = tJobItemList;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public Integer getVehicle() {
        return vehicle;
    }

    public void setVehicle(Integer vehicle) {
        this.vehicle = vehicle;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

}