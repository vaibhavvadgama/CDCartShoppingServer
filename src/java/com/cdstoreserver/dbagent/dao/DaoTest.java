/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao;

/**
 *
 * @author Utkarsh
 */
public class DaoTest {
    
    public static void main(String[] args){
    
    CdDao test = new CdDao();
    System.out.println("data"+test.getProductList(1));
    
    }
}
