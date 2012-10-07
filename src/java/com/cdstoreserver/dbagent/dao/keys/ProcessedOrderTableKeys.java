/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao.keys;

/**
 *
 * @author Vaibhav
 */
public class ProcessedOrderTableKeys {
    
    public static String key_orderid = "orderid";
    public static String key_userid = "userid";
    public static String key_shippingtype = "shippingtype";
    public static String key_shipping_addressid = "shipping_addressid";
    public static String key_billing_addressid = "billing_addressid";
    public static String key_order_date = "order_date";
    public static String key_order_status = "order_status";
    public static String key_isactive = "isactive";
    public static String key_createddate = "createddate";
    public static String key_modifieddate = "modifieddate";
    
    public static String columnKeys [] = {
            key_orderid,
            key_userid,
            key_shippingtype,
            key_shipping_addressid,
            key_billing_addressid,
            key_order_date,
            key_order_status,
            key_isactive,
            key_createddate,
            key_modifieddate
        };
    
    public static String [] getColumnKeys() {
        return columnKeys;
    }
    
}
