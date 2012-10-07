/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author Utkarsh
 */
public class DbAgentTest {
    
    public static void main(String[] args){
        
        //To test properties
        /*ShopDbDao test = new ShopDbDao();
        String driver= test.getProperty("driver");
        System.out.println(driver);*/
        //To test insert,update or delete
        /*
        int rows;
        ShopDbAgent test2 = new ShopDbAgent();
        String[] values = new String[]{"Rock","It is a rock music","1","2012-09-21 02:00:00","2012-09-21 02:00:00"};
        rows= test2.executeSQL("query2",values);
        System.out.println("Rows"+rows);*/
        
        ShopDbAgent test2 = new ShopDbAgent();
        String[] values = new String[]{};
//        List<HashMap<String,Object>> values2 = test2.getQueryResult("query1", values);
//        
//        for (HashMap<String, Object> map : values2){
//            for (Entry<String, Object> entry : map.entrySet())
//            {
//                System.out.print(entry.getKey() + " => " + entry.getValue());
//            }
//        }
       
    }
    
}
