/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.beans;

/**
 *
 * @author Vaibhav
 * Desc:Getters/setters for cdmains table Columns
 */
public class CdBean {

    int cdId;
    String cdTitle;
    double cdPrice;
    int categoryId;
    String cdImage;
    String cdImagePath;
    String publishDate;    
    double taxPer;    
    String createdDate;   
    public String status;
    public String errormessage;
       
    public CdBean() {
        
    }

   
    

    public CdBean(int cdId, String cdTitle, double cdPrice, int categoryId, String cdImage, String publishDate, double taxPer, String createdDate) {
        this.cdId = cdId;
        this.cdTitle = cdTitle;
        this.cdPrice = cdPrice;
        this.categoryId = categoryId;
        this.cdImage = cdImage;
        this.publishDate = publishDate;
        this.taxPer = taxPer;
        this.createdDate = createdDate;        
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

    

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

     public String getCdImagePath() {
        return cdImagePath;
    }

    public void setCdImagePath(String cdImagePath) {
        this.cdImagePath = cdImagePath;
    }
    
    
}
