/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao.keys;

/**
 *
 * @author Vaibhav
 */
public class UserTableKeys {
    
    public static String key_user_id = "user_id";
    public static String key_user_firstname = "user_firstname";
    public static String key_user_lastname = "user_lastname";
    public static String key_user_email = "user_email";
    public static String key_user_password = "user_password";
    public static String key_user_role = "user_role";
    public static String key_user_cardtype="user_cardtype";
    public static String key_user_cardnumber="user_cardnumber";
    public static String key_user_cardcvv="user_cvv";
    public static String key_user_cardexpdate="user_cardexpdate";
    public static String key_isactive = "isactive";
    public static String key_createddate = "createddate";
    public static String key_modifieddate = "modifieddate";
    
    public static String columnKeys [] = {
            key_user_id,
            key_user_firstname,
            key_user_lastname,
            key_user_email,
            key_user_password,
            key_user_role,
            key_user_cardtype,
            key_user_cardnumber,
            key_user_cardcvv,
            key_user_cardexpdate,
            key_isactive,
            key_createddate,
            key_modifieddate
        };
    
    public static String [] getColumnKeys() {
        return columnKeys;
    }
    
}
