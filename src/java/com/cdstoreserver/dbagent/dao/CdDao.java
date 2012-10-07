/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao;

import com.cdstoreserver.dbagent.DbAgentUtil;
import com.cdstoreserver.dbagent.ShopDbAgent;
import com.cdstoreserver.dbagent.beans.CdBean;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 *
 * @author Utkarsh
 */
public class CdDao {

    ShopDbAgent objDb = null;
    DbAgentUtil objProp = null;
    
//    class CdDaoConfig {
//        public static String key_cdid = "";
//        public static String key_title;
//        public static String key_price;
//        public static String key_categoryId;
//        public static String key_image;
//        public static String key_publishedDate;
//        public static String key_taxPer;
//        public static String key_isActive;
//        public static String key_createdDate;
//        public static String key_modifiedDate;
//    }

    public CdDao() {
        objDb = new ShopDbAgent();
        objProp = new DbAgentUtil();
    }

    public ArrayList<CdBean> getProductList(int intCategoryId) {
        ArrayList<CdBean> itemList = null;
        String intCatId = "" + intCategoryId;
        itemList = iterateResultSet(objDb.getQueryResult(objProp.getProperty("query1"), new String[]{intCatId}));
        return itemList;
    }

    public ArrayList<CdBean> iterateResultSet(ResultSet rs) {
        ArrayList<CdBean> cdList = new ArrayList<CdBean>();

        try {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            
            String [] columnNames = {
                objProp.getProperty("key_cdid"),
                objProp.getProperty("key_cdtitle"),
                objProp.getProperty("key_cdprice"),
                objProp.getProperty("key_categoryid"),
                objProp.getProperty("key_cdimage"),
                objProp.getProperty("key_cdpublisheddate"),
                objProp.getProperty("key_cdtaxper"),
                objProp.getProperty("key_cdisactive"),
                objProp.getProperty("key_cdcreateddate"),
                objProp.getProperty("key_cdmodifieddate")
            };
            while (rs.next()) {
//                for() {
//                    
//                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cdList;
    }
}
