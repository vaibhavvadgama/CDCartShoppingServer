/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.ws.productcatalog;

import com.cdstoreserver.dbagent.beans.CDList;
import com.cdstoreserver.dbagent.beans.CategoryList;
import com.cdstoreserver.dbagent.dao.CategoryDao;
import com.cdstoreserver.dbagent.dao.CdDao;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Vaibhav
 */
@WebService(serviceName = "ProductCatalogWS")
public class ProductCatalogWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "test")
    public String test() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getProductList")
    public CDList getProductList(@WebParam(name = "categoryId") Integer categoryId) {
        //TODO write your implementation code here:
        CDList responseObj = new CDList();
        
        CdDao dao = new CdDao();
        ArrayList items = dao.getProductList(categoryId);
        
//        for(CdBean item : items) {
//            responseObj.cdList.add(item);
//        }
//        responseObj.cdList.add(new CDItem(1, "Linkin Park", 10.99, 2, "cd1.png", "25/10/2012 11:00:35", true));
//        responseObj.cdList.add(new CDItem(2, "Album 2", 12.99, 2, "cd2.png", "26/10/2012 12:00:35", true));
        
        return responseObj;
    }
    
    @WebMethod(operationName = "getCategoryList")
    public CategoryList getCategoryList() {
        CategoryList responseObject = new CategoryList();
        
        CategoryDao catDao = new CategoryDao();
        responseObject.category = catDao.getCategoryList();
        
        if(responseObject.category.size() == 0) {
            responseObject.status = "error";
            responseObject.errormessage = "No category found!";
        } else {
            responseObject.status = "success";
            responseObject.errormessage = "";
        }
        
        return responseObject;
    }
}
