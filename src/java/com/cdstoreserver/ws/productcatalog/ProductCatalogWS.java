/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.ws.productcatalog;

import com.cdstoreserver.dbagent.beans.CDList;
import com.cdstoreserver.dbagent.beans.CategoryList;
import com.cdstoreserver.dbagent.dao.CategoryDao;
import com.cdstoreserver.dbagent.dao.CdDao;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
        
        responseObj.cd =  dao.getProductList(categoryId);
        
        
        if(responseObj.cd.size() == 0) {
            responseObj.status = "error";
            responseObj.errormessage = "No product found!";
        } else {
            responseObj.status = "success";
            responseObj.errormessage = "";
        }
        
        return responseObj;       
        
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getProductInfo")
    public CDList getProductInfo(@WebParam(name = "productId") Integer productId) {
        //TODO write your implementation code here:
        CDList responseObj = new CDList();
        
        CdDao dao = new CdDao();
        
        responseObj.cd =  dao.getProductInfo(productId);
        
        if(responseObj.cd.size() == 0) {
            responseObj.status = "error";
            responseObj.errormessage = "No product data found!";
        } else {
            responseObj.status = "success";
            responseObj.errormessage = "";
        }
        
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
