/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao.keys;

/**
 *
 * @author Vaibhav
 */
public class CdTableKeys {
    
    public static String key_cd_id = "cd_id";
    public static String key_cd_title = "cd_title";
    public static String key_cd_price = "cd_price";
    public static String key_category_id = "category_id";
    public static String key_cd_image = "cd_image";
    public static String key_cd_publisheddate = "cd_publisheddate";
    public static String key_cd_taxper = "cd_taxper";
    public static String key_isactive = "isactive";
    public static String key_createddate = "createddate";
    public static String key_modifieddate = "modifieddate";
    
    public static String columnKeys [] = {
            key_cd_id,
            key_cd_title,
            key_cd_price,
            key_category_id,
            key_cd_image,
            key_cd_publisheddate,
            key_cd_taxper,
            key_isactive,
            key_createddate,
            key_modifieddate
        };
    
    public static String [] getColumnKeys() {
        return columnKeys;
    }
    
}
