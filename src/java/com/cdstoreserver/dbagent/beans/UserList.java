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
public class UserList {
    
    public String status = "";
    public String errormessage = "";
    
    public ArrayList<UserBean> user;

    public UserList() {
        user = new ArrayList<UserBean>();
    }
    
}
