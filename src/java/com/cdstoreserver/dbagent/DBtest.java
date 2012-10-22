/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent;

import java.sql.Connection;

/**
 *
 * @author Utkarsh
 */
public class DBtest {
    public static void main(String [] args){
        
        ShopDbConnectionPool objpool = new ShopDbConnectionPool();
        try {
            Connection con = objpool.getConnection();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
