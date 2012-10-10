/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao;

import com.cdstoreserver.dbagent.beans.AddressBean;
import com.cdstoreserver.dbagent.beans.ProcessedOrdersBean;

/**
 *
 * @author Utkarsh
 */
public class DaoTest {
    
    public static void main(String[] args){
    
    /*AddressDao test = new AddressDao();
    AddressBean address = new AddressBean();
    address.setAddressType("ship");
    address.setCity("ottawa");
    address.setPhone("76676767");
    address.setState("ON");
    address.setStreetName("mccarthy");
    address.setStreetNo("34");
    address.setUserId(1);
    address.setZip("k1v9h8");
    System.out.println("data"+test.addAddress(address));*/
        
    OrderDao test = new OrderDao();
    ProcessedOrdersBean purchaseOrder = new ProcessedOrdersBean();
    purchaseOrder.setOrderId(1);
    System.out.println("data"+test.confirmOrder(purchaseOrder,true));
    
    
    }
}
