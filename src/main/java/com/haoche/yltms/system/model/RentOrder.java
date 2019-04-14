package com.haoche.yltms.system.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "rent_order", schema = "ylt", catalog = "")
public class RentOrder extends BaseModel{
    public static  final String UN_PAY = "未支付";
    public static  final String PAY = "已支付";
    public static  final String OBTAIN_CAR = "已取车";
    public static  final String RETURN_CAR = "已还车";
    public static  final String CANCEL = "已取消";
    public static  final String INVALID = "已作废";

    private String shopName;
    private String userId;
    private String vehicleId;
    private String rent;
    private String costRent;
    private String obtainProv;
    private String obtainCity;
    private String obtainArea;
    private String returnProv;
    private String returnCity;
    private String returnArea;
    private String orderStatus;
    private String orderNo;

    @Basic
    @Column(name = "SHOP_NAME")
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Basic
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "VEHICLE_ID")
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
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
    @Column(name = "COST_RENT")
    public String getCostRent() {
        return costRent;
    }

    public void setCostRent(String costRent) {
        this.costRent = costRent;
    }

    @Basic
    @Column(name = "OBTAIN_PROV")
    public String getObtainProv() {
        return obtainProv;
    }

    public void setObtainProv(String obtainProv) {
        this.obtainProv = obtainProv;
    }

    @Basic
    @Column(name = "OBTAIN_CITY")
    public String getObtainCity() {
        return obtainCity;
    }

    public void setObtainCity(String obtainCity) {
        this.obtainCity = obtainCity;
    }

    @Basic
    @Column(name = "OBTAIN_AREA")
    public String getObtainArea() {
        return obtainArea;
    }

    public void setObtainArea(String obtainArea) {
        this.obtainArea = obtainArea;
    }

    @Basic
    @Column(name = "RETURN_PROV")
    public String getReturnProv() {
        return returnProv;
    }

    public void setReturnProv(String returnProv) {
        this.returnProv = returnProv;
    }

    @Basic
    @Column(name = "RETURN_CITY")
    public String getReturnCity() {
        return returnCity;
    }

    public void setReturnCity(String returnCity) {
        this.returnCity = returnCity;
    }

    @Basic
    @Column(name = "RETURN_AREA")
    public String getReturnArea() {
        return returnArea;
    }

    public void setReturnArea(String returnArea) {
        this.returnArea = returnArea;
    }

    @Basic
    @Column(name = "ORDER_STATUS")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "ORDER_NO")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentOrder rentOrder = (RentOrder) o;
        return Objects.equals(orderNo, rentOrder.orderNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo);
    }
}
