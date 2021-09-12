package com.tik.mysystem.generator.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FreightConfig {
    private Integer id;

    private String name;

    private Date expiryStartDate;

    private Date expiryEndDate;

    private Integer carrierId;

    private Boolean deliveryType;

    private BigDecimal price;

    private Boolean computeMode;

    private Boolean status;

    private Integer createUserId;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getExpiryStartDate() {
        return expiryStartDate;
    }

    public void setExpiryStartDate(Date expiryStartDate) {
        this.expiryStartDate = expiryStartDate;
    }

    public Date getExpiryEndDate() {
        return expiryEndDate;
    }

    public void setExpiryEndDate(Date expiryEndDate) {
        this.expiryEndDate = expiryEndDate;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public Boolean getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Boolean deliveryType) {
        this.deliveryType = deliveryType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getComputeMode() {
        return computeMode;
    }

    public void setComputeMode(Boolean computeMode) {
        this.computeMode = computeMode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}