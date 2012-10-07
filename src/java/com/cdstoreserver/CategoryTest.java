/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver;

import com.cdstoreserver.dbagent.beans.CategoryBean;
import com.cdstoreserver.dbagent.dao.CategoryDao;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class CategoryTest {
    
    public static void main(String [] args) {
        CategoryTest test = new CategoryTest();
        test.getCategoryList();
    }
    
    public ArrayList<CategoryBean> getCategoryList() {
        ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();
        
        CategoryDao catDao = new CategoryDao();
        categoryList = catDao.getCategoryList();
        
        return categoryList;
    }
    
}
