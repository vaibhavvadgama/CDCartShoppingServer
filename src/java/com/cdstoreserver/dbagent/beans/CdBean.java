/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.beans;

/**
 *
 * @author Vaibhav
 */
public class CdBean {

    int cdId;
    String cdTitle;
    double cdPrice;
    int categoryId;
    String cdImage;
    String publishDate;
    double taxPer;
    boolean isActive;
    String createdDate;
    String modifiedDate;

    public CdBean(int cdId, String cdTitle, double cdPrice, int categoryId, String cdImage, String publishDate, double taxPer, boolean isActive, String createdDate, String modifiedDate) {
        this.cdId = cdId;
        this.cdTitle = cdTitle;
        this.cdPrice = cdPrice;
        this.categoryId = categoryId;
        this.cdImage = cdImage;
        this.publishDate = publishDate;
        this.taxPer = taxPer;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public int getCdId() {
        return cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    public String getCdTitle() {
        return cdTitle;
    }

    public void setCdTitle(String cdTitle) {
        this.cdTitle = cdTitle;
    }

    public double getCdPrice() {
        return cdPrice;
    }

    public void setCdPrice(double cdPrice) {
        this.cdPrice = cdPrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCdImage() {
        return cdImage;
    }

    public void setCdImage(String cdImage) {
        this.cdImage = cdImage;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    
    public double getTaxPer() {
        return taxPer;
    }

    public void setTaxPer(double taxPer) {
        this.taxPer = taxPer;
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
