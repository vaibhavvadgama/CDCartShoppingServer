/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.beans;

import java.util.ArrayList;
/**
 *
 * @author Utkarsh
 */
public class AddressList {
    public String status = "";
    public String errormessage = "";
    
    public ArrayList<AddressBean> address;

    public AddressList() {
        address = new ArrayList<AddressBean>();
    }
}
