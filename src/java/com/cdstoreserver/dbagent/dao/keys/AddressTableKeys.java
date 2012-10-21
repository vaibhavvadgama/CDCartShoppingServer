/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao.keys;

/**
 *
 * @author Vaibhav
 * Desc:address mains table rows/keys
 */
public class AddressTableKeys {
    
    public static String key_adress_id = "adress_id";
    public static String key_adress_type = "adress_type";
    public static String key_user_id = "user_id";
    public static String key_adress_streetno = "adress_streetno";
    public static String key_adress_streetname = "adress_streetname";
    public static String key_adress_city = "adress_city";
    public static String key_adress_state = "adress_state";
    public static String key_adress_zip = "adress_zip";
    public static String key_adress_phone = "adress_phone";
    public static String key_isactive = "isactive";
    public static String key_createddate = "createddate";
    public static String key_modifieddate = "modifieddate";
    
    public static String columnKeys [] = {
            key_adress_id,
            key_adress_type,
            key_user_id,
            key_adress_streetno,
            key_adress_streetname,
            key_adress_city,
            key_adress_state,
            key_adress_zip,
            key_adress_phone,
            key_isactive,
            key_createddate,
            key_modifieddate
        };
    
    public static String [] getColumnKeys() {
        return columnKeys;
    }
    
}
