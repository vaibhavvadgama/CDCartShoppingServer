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
    
    public String status = "";
    public String errormessage = "";
    
    public ArrayList<CdBean> cd;

    public CDList() {
        cd = new ArrayList<CdBean>();
    }
    
}
