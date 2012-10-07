/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.beans;

import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class CategoryList {
    
    public String status = "";
    public String errormessage = "";
    public ArrayList<CategoryBean> category;

    public CategoryList() {
        category = new ArrayList<CategoryBean>();
    }
    
}
