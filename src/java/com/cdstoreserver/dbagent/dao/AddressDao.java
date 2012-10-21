/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao;
import com.cdstoreserver.SystemLogger;
import com.cdstoreserver.dbagent.DbAgentUtil;
import com.cdstoreserver.dbagent.ShopDbAgent;
import com.cdstoreserver.dbagent.beans.AddressBean;
import com.cdstoreserver.dbagent.dao.keys.AddressTableKeys;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 *
 * @author Utkarsh
 * Desc:It's class which performs data access operations on addressmains table 
 */
public class AddressDao {
    
    ShopDbAgent objDb = null;
    DbAgentUtil objProp = null;

    public AddressDao() {
        objDb = new ShopDbAgent();
        objProp = new DbAgentUtil();
    }
    
    /*
     * Param: userid
     * Return: addresslist
     * Desc: function to get user's addresses from provided user id
     * 
     */
    public ArrayList<AddressBean> getAddresses(int intUserId){        
        
        ArrayList<AddressBean> addressList = null;
        String strUserId = ""+intUserId;
        String[] values = new String[]{strUserId};
        ResultSet rs = objDb.getQueryResult("q6.2", values);
        SystemLogger.out("RS : " + rs);
        addressList = iterateResultSet(rs);
        return addressList;
    }
    
    /*
     * Param: addressbean
     * Return: address inserted id
     * Desc: function to add user's address to addressmains table
     * 
     */
    public int addAddress(AddressBean address){
        int insertId;        
        String[] values = new String[]{address.getAddressType(),""+address.getUserId(),address.getStreetNo(),address.getStreetName(),address.getCity(),address.getState(),address.getZip(),address.getPhone()};
        insertId = objDb.executeSQL("q6.1",values);        
        return insertId;
    }
    
    /*
     * Param: resultset
     * Return: arraylist of address
     * Desc: function to iterate through various fields of addressmains and provide list of addresses
     * 
     */
    public ArrayList<AddressBean> iterateResultSet(ResultSet rs) {
        ArrayList<AddressBean> userList = new ArrayList<AddressBean>();
        
        try {
            
            String[] columnNames = AddressTableKeys.getColumnKeys();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                AddressBean userBean = new AddressBean();
                for (String col : columnNames) {
                    try {
                        if (col.equals(AddressTableKeys.key_adress_id)) {
                            userBean.setAddressId(
                                    Integer.parseInt(rs.getString(AddressTableKeys.key_adress_id)));
                        } else if (col.equals(AddressTableKeys.key_adress_type)) {
                            userBean.setAddressType(
                                    rs.getString(AddressTableKeys.key_adress_type));
                        } else if (col.equals(AddressTableKeys.key_user_id)) {
                            userBean.setUserId(
                                    Integer.parseInt(rs.getString(AddressTableKeys.key_user_id)));
                        } else if (col.equals(AddressTableKeys.key_adress_streetno)) {
                            userBean.setStreetNo(
                                    rs.getString(AddressTableKeys.key_adress_streetno));
                        } else if (col.equals(AddressTableKeys.key_adress_streetname)) {
                            userBean.setStreetName(
                                    rs.getString(AddressTableKeys.key_adress_streetname));
                        } else if (col.equals(AddressTableKeys.key_adress_state)) {
                            userBean.setState(
                                    rs.getString(AddressTableKeys.key_adress_state));
                        } else if (col.equals(AddressTableKeys.key_adress_city)) {
                            userBean.setCity(
                                    rs.getString(AddressTableKeys.key_adress_city));
                        } else if (col.equals(AddressTableKeys.key_adress_zip)) {
                            userBean.setZip(
                                    rs.getString(AddressTableKeys.key_adress_zip));
                        } else if (col.equals(AddressTableKeys.key_adress_phone)) {
                            userBean.setPhone(
                                    rs.getString(AddressTableKeys.key_adress_phone));
                        } else if (col.equals(AddressTableKeys.key_createddate)) {
                            userBean.setCreatedDate(
                                    rs.getString(AddressTableKeys.key_createddate));
                        } else if (col.equals(AddressTableKeys.key_isactive)) {
                            userBean.setIsActive(
                                    Boolean.parseBoolean(rs.getString(AddressTableKeys.key_isactive)));
                        } else {
                            System.out.println("Error in fetching Attribute");
                        }
                    } catch (Exception resultSetException) {
                        resultSetException.printStackTrace();
                    }
                }
                userList.add(userBean);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }
    
    
}
