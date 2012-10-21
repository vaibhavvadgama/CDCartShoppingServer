/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao;

import com.cdstoreserver.SystemLogger;
import com.cdstoreserver.dbagent.DbAgentUtil;
import com.cdstoreserver.dbagent.ShopDbAgent;
import com.cdstoreserver.dbagent.beans.UserBean;
import com.cdstoreserver.dbagent.dao.keys.UserTableKeys;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 *
 * @author Utkarsh
 * Desc:It's class which performs data access operations on usermains table 
 */
public class UserDao {
    
    ShopDbAgent objDb = null;
    DbAgentUtil objProp = null;

    public UserDao() {
        objDb = new ShopDbAgent();
        objProp = new DbAgentUtil();
    }

    /*
     * Param: username,password
     * Return: userbean
     * Desc: function to get user's data from provided username(email) and password
     * 
     */
    public UserBean getUserInfo(String strUserName,String strPassword){        
      
        UserBean userData = null;        
        String[] values = new String[]{strUserName,strPassword};
        ResultSet rs = objDb.getQueryResult("q5.2", values);
        SystemLogger.out("RS : " + rs);
        userData = iterateResultSet(rs);
        return userData;
    }
    
    /*
     * Param: userbean
     * Return: user inserted id
     * Desc: function to add user's information to usermains table
     * 
     */
    public UserBean addUser(UserBean user){
        int insertId;        
        UserBean returnUser = new UserBean();
        String[] values = new String[]{user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword()};
        insertId = objDb.executeSQL("q5.1",values);
        returnUser.setUserId(insertId);      
        return returnUser;
    }
    
    /*
     * Param: resultset
     * Return: userbean
     * Desc: function to iterate through various fields of usermains and provide user data
     * 
     */
    public UserBean iterateResultSet(ResultSet rs) {
        UserBean userBean = new UserBean();
        
        try {
            
            String[] columnNames = UserTableKeys.getColumnKeys();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                
                for (String col : columnNames) {
                    try {
                        if (col.equals(UserTableKeys.key_user_id)) {
                            userBean.setUserId(
                                    Integer.parseInt(rs.getString(UserTableKeys.key_user_id)));
                        } else if (col.equals(UserTableKeys.key_user_firstname)) {
                            userBean.setFirstName(
                                    rs.getString(UserTableKeys.key_user_firstname));
                        } else if (col.equals(UserTableKeys.key_user_lastname)) {
                            userBean.setLastName(
                                    rs.getString(UserTableKeys.key_user_lastname));
                        } else if (col.equals(UserTableKeys.key_user_email)) {
                            userBean.setEmail(
                                    rs.getString(UserTableKeys.key_user_email));
                        } else if (col.equals(UserTableKeys.key_createddate)) {
                            userBean.setCreatedDate(
                                    rs.getString(UserTableKeys.key_createddate));
                        } else if (col.equals(UserTableKeys.key_isactive)) {
                            userBean.setIsActive(
                                    Boolean.parseBoolean(rs.getString(UserTableKeys.key_isactive)));
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
        return userBean;
    }
    
}
