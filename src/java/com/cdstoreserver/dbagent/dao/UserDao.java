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
 */
public class UserDao {
    
    ShopDbAgent objDb = null;
    DbAgentUtil objProp = null;

    public UserDao() {
        objDb = new ShopDbAgent();
        objProp = new DbAgentUtil();
    }

    
    public ArrayList<UserBean> getUserInfo(String strUserName,String strPassword){        
        
        ArrayList<UserBean> userData = null;        
        String[] values = new String[]{strUserName,strPassword};
        ResultSet rs = objDb.getQueryResult("q5.2", values);
        SystemLogger.out("RS : " + rs);
        userData = iterateResultSet(rs);
        return userData;
    }
    
    public ArrayList<UserBean> addUser(UserBean user){
        int insertId;
        ArrayList<UserBean> userData = new ArrayList<UserBean>();
        UserBean returnUser = new UserBean();
        String[] values = new String[]{user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),user.getCardType(),user.getCardNumber(),""+user.getCvv(),user.getExpDate()};
        insertId = objDb.executeSQL("q5.1",values);
        if(insertId!=0){
            returnUser.setUserId(insertId);
            userData.add(returnUser);
            
        } else {
            userData = null;
        } 
        return userData;
    }

    public ArrayList<UserBean> iterateResultSet(ResultSet rs) {
        ArrayList<UserBean> userList = new ArrayList<UserBean>();
        
        try {
            
            String[] columnNames = UserTableKeys.getColumnKeys();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                UserBean userBean = new UserBean();
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
                userList.add(userBean);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }
    
}
