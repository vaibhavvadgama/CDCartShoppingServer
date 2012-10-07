/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.beans;

/**
 *
 * @author Vaibhav
 */
public class CategoryBean {
    
    int categoryId;
    String categoryName;
    String categoryDesc;
    boolean isActive;
    String createdDate;
    String modifiedDate;

    public CategoryBean() {
    }

    public CategoryBean(int categoryId, String categoryName, String categoryDesc, boolean isActive, String createdDate, String modifiedDate) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
}
