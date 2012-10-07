/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao;

import com.cdstoreserver.SystemLogger;
import com.cdstoreserver.dbagent.DbAgentUtil;
import com.cdstoreserver.dbagent.ShopDbAgent;
import com.cdstoreserver.dbagent.beans.CategoryBean;
import com.cdstoreserver.dbagent.dao.keys.CategoryTableKeys;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class CategoryDao {
    
    ShopDbAgent objDb = null;
    DbAgentUtil objProp = null;
    
    public CategoryDao() {
        objDb = new ShopDbAgent();
        objProp = new DbAgentUtil();
    }
    
    public ArrayList<CategoryBean> getCategoryList() {
        ArrayList<CategoryBean> itemList = null;
        
        ResultSet rs = objDb.getQueryResult("q1.1", null);
        SystemLogger.out("RS : " + rs);
        itemList = iterateResultSet(rs);
        
        return itemList;
    }
    
    public ArrayList<CategoryBean> iterateResultSet(ResultSet rs) {
        ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();
        
        try {
//            String[] columnNames = getAllProperties();
            String[] columnNames = CategoryTableKeys.getColumnKeys();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                CategoryBean categoryBean = new CategoryBean();
                for (String col : columnNames) {
                    try {
                        if (col.equals(CategoryTableKeys.key_category_id)) {
                            categoryBean.setCategoryId(
                                    Integer.parseInt(rs.getString(CategoryTableKeys.key_category_id)));
                        } else if (col.equals(CategoryTableKeys.key_category_name)) {
                            categoryBean.setCategoryName(
                                    rs.getString(CategoryTableKeys.key_category_name));
                        } else if (col.equals(CategoryTableKeys.key_category_desc)) {
                            categoryBean.setCategoryDesc(
                                    rs.getString(CategoryTableKeys.key_category_desc));
                        } else if (col.equals(CategoryTableKeys.key_isactive)) {
                            categoryBean.setIsActive(Boolean.parseBoolean(
                                    rs.getString(CategoryTableKeys.key_isactive)));
                        } else if (col.equals(CategoryTableKeys.key_createddate)) {
                            categoryBean.setCreatedDate(
                                    rs.getString(CategoryTableKeys.key_createddate));
                        } else if (col.equals(CategoryTableKeys.key_modifieddate)) {
                            categoryBean.setModifiedDate(
                                    rs.getString(CategoryTableKeys.key_modifieddate));
                        } else {
                            System.out.println("Error in fetching Attribute");
                        }
                    } catch (Exception resultSetException) {
                        resultSetException.printStackTrace();
                    }
                }
                categoryList.add(categoryBean);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return categoryList;
    }
}
