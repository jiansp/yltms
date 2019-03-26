package com.haoche.yltms.system.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "vehicle", schema = "ylt", catalog = "")
public class Vehicle extends BaseModel {
    public static final String ENABLE = "0";
    public static final String DISABLE = "1";
    private String license;
    private String brand;
    private String model;
    private String seatNum;
    private String colour;
    private String vin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date firstLicense;
    private String isDelete;
    private String rent;
    private String isStop;

    @Basic
    @Column(name = "LICENSE")
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Basic
    @Column(name = "BRAND")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "MODEL")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "SEAT_NUM")
    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    @Basic
    @Column(name = "COLOUR")
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Basic
    @Column(name = "VIN")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Basic
    @Column(name = "FIRST_LICENSE")
    public Date getFirstLicense() {
        return firstLicense;
    }

    public void setFirstLicense(Date firstLicense) {
        this.firstLicense = firstLicense;
    }

    @Basic
    @Column(name = "IS_DELETE")
    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Basic
    @Column(name = "RENT")
    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    @Basic
    @Column(name = "IS_STOP")
    public String getIsStop() {
        return isStop;
    }

    public void setIsStop(String isStop) {
        this.isStop = isStop;
    }

}
