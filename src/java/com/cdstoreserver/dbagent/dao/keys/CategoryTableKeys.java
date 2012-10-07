/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao.keys;

/**
 *
 * @author Vaibhav
 */
public class CategoryTableKeys {
    
    public static String key_category_id = "category_id";
    public static String key_category_name = "category_name";
    public static String key_category_desc = "category_desc";
    public static String key_isactive = "isactive";
    public static String key_createddate = "createddate";
    public static String key_modifieddate = "modifieddate";
    
    public static String columnKeys [] = {
            key_category_id,
            key_category_name,
            key_category_desc,
            key_isactive,
            key_createddate,
            key_modifieddate
        };
    
    public static String [] getColumnKeys() {
        return columnKeys;
    }
    
}
