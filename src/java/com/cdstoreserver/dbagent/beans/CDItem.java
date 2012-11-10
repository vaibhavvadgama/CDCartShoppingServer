/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.beans;

/**
 *
 * @author Vaibhav
 */
public class CDItem {

    public int cdId;
    public String cdTitle;
    public double cdPrice;
    public int categoryId;
    public String cdImage;
    public String cdImagePath;
    public String publishDate;
    public boolean isActive;

    public CDItem(int cdId, String cdTitle, double cdPrice, int categoryId, String cdImage, String publishDate, boolean isActive) {
        this.cdId = cdId;
        this.cdTitle = cdTitle;
        this.cdPrice = cdPrice;
        this.categoryId = categoryId;
        this.cdImage = cdImage;
        this.publishDate = publishDate;
        this.isActive = isActive;
    }
}
