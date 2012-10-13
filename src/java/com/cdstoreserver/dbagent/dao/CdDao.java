/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao;

import com.cdstoreserver.SystemLogger;
import com.cdstoreserver.dbagent.DbAgentUtil;
import com.cdstoreserver.dbagent.ShopDbAgent;
import com.cdstoreserver.dbagent.beans.CdBean;
import com.cdstoreserver.dbagent.dao.keys.CdTableKeys;
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

    public CdDao() {
        objDb = new ShopDbAgent();
        objProp = new DbAgentUtil();
    }

    public ArrayList<CdBean> getProductList(int intCategoryId) {
        ArrayList<CdBean> itemList = null;
        String strCategoryId = ""+intCategoryId;
        String[] values = new String[]{strCategoryId};
        ResultSet rs = objDb.getQueryResult("q2.1", values);
        SystemLogger.out("RS : " + rs);
        itemList = iterateResultSet(rs);        
        return itemList;
    }
    
    public CdBean getProductInfo(int intProductId){
        
        CdBean itemList = null;
        String strProductId = ""+intProductId;
        String[] values = new String[]{strProductId};
        ResultSet rs = objDb.getQueryResult("q2.2", values);
        SystemLogger.out("RS : " + rs);
        itemList = iterateResultSetPI(rs);
        return itemList;
    }

    public ArrayList<CdBean> iterateResultSet(ResultSet rs) {
        ArrayList<CdBean> cdList = new ArrayList<CdBean>();
        
        try {
            
            String[] columnNames = CdTableKeys.getColumnKeys();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                CdBean cdBean = new CdBean();
                for (String col : columnNames) {
                    try {
                        if (col.equals(CdTableKeys.key_cd_id)) {
                            cdBean.setCdId(
                                    Integer.parseInt(rs.getString(CdTableKeys.key_cd_id)));
                        } else if (col.equals(CdTableKeys.key_cd_title)) {
                            cdBean.setCdTitle(
                                    rs.getString(CdTableKeys.key_cd_title));
                        } else if (col.equals(CdTableKeys.key_cd_price)) {
                            cdBean.setCdPrice(
                                    Double.parseDouble(rs.getString(CdTableKeys.key_cd_price)));
                        } else if (col.equals(CdTableKeys.key_category_id)) {
                            cdBean.setCategoryId(
                                    Integer.parseInt(rs.getString(CdTableKeys.key_category_id)));
                        } else if (col.equals(CdTableKeys.key_cd_image)) {
                            cdBean.setCdImage(
                                    rs.getString(CdTableKeys.key_cd_image));
                        } else if (col.equals(CdTableKeys.key_cd_publisheddate)) {
                            cdBean.setPublishDate(
                                    rs.getString(CdTableKeys.key_cd_publisheddate));
                        } else if (col.equals(CdTableKeys.key_cd_taxper)) {
                            cdBean.setTaxPer(
                                    Double.parseDouble(rs.getString(CdTableKeys.key_cd_taxper)));
                        } else {
                            System.out.println("Error in fetching Attribute");
                        }
                    } catch (Exception resultSetException) {
                        resultSetException.printStackTrace();
                    }
                }
                cdList.add(cdBean);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cdList;
    }
    
    
    public CdBean iterateResultSetPI(ResultSet rs) {
        CdBean cdBean = new CdBean();
        
        try {
            
            String[] columnNames = CdTableKeys.getColumnKeys();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                
                for (String col : columnNames) {
                    try {
                        if (col.equals(CdTableKeys.key_cd_id)) {
                            cdBean.setCdId(
                                    Integer.parseInt(rs.getString(CdTableKeys.key_cd_id)));
                        } else if (col.equals(CdTableKeys.key_cd_title)) {
                            cdBean.setCdTitle(
                                    rs.getString(CdTableKeys.key_cd_title));
                        } else if (col.equals(CdTableKeys.key_cd_price)) {
                            cdBean.setCdPrice(
                                    Double.parseDouble(rs.getString(CdTableKeys.key_cd_price)));
                        } else if (col.equals(CdTableKeys.key_category_id)) {
                            cdBean.setCategoryId(
                                    Integer.parseInt(rs.getString(CdTableKeys.key_category_id)));
                        } else if (col.equals(CdTableKeys.key_cd_image)) {
                            cdBean.setCdImage(
                                    rs.getString(CdTableKeys.key_cd_image));
                        } else if (col.equals(CdTableKeys.key_cd_publisheddate)) {
                            cdBean.setPublishDate(
                                    rs.getString(CdTableKeys.key_cd_publisheddate));
                        } else if (col.equals(CdTableKeys.key_cd_taxper)) {
                            cdBean.setTaxPer(
                                    Double.parseDouble(rs.getString(CdTableKeys.key_cd_taxper)));
                        } else {
                            System.out.println("Error in fetching Attribute");
                        }
                    } catch (Exception resultSetException) {
                        resultSetException.printStackTrace();
                    }
                }
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cdBean;
    }
}
