/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.beans;

import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class CDList {
    
    public String error = "";
    
    public ArrayList<CdBean> cdList;

    public CDList() {
        cdList = new ArrayList<CdBean>();
    }
    
}
