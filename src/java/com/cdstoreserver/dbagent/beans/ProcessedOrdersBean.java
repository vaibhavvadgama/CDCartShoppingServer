/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.beans;

/**
 *
 * @author Vaibhav
 * Desc:Getters/setters for ordermains table Columns
 */
public class ProcessedOrdersBean {
    
    int orderId;
    int userId;
    String shippingType;
    int shippingAddressId;
    int billingAddressId;
    String orderDate;
    public String status = "";
    public String errormessage = "";
    String orderStatus;
    String createdDate;
    
    
    public ProcessedOrdersBean() {
        
    }

    public ProcessedOrdersBean(int orderId, int userId, String shippingType, int shippingAddressId, int billingAddressId, String orderDate, String orderStatus, boolean isActive, String createdDate, String modifiedDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.shippingType = shippingType;
        this.shippingAddressId = shippingAddressId;
        this.billingAddressId = billingAddressId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;        
        this.createdDate = createdDate;
        
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public int getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(int billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }   

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

        
}
