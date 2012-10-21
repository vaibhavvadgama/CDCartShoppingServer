/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.ws.orderprocess;

import com.cdstoreserver.dbagent.beans.AddressBean;
import com.cdstoreserver.dbagent.beans.CDList;
import com.cdstoreserver.dbagent.beans.CdBean;
import com.cdstoreserver.dbagent.beans.ProcessedOrdersBean;
import com.cdstoreserver.dbagent.dao.OrderDao;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Vaibhav
 */
@WebService(serviceName = "OrderProcessWS")
public class OrderProcessWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createOrder")
    public ProcessedOrdersBean createOrder(@WebParam(name = "shoppingCartInfo") ArrayList<CdBean> shoppingCartInfo, @WebParam(name = "shippingInfo") AddressBean shippingInfo) {
        
        ProcessedOrdersBean responseObj = new ProcessedOrdersBean();
        
        OrderDao dao = new OrderDao();
        
        responseObj =  dao.createOrder(shoppingCartInfo, shippingInfo);
        //if order creation fails then set error to show on front end
        if(responseObj==null) {
            responseObj.status = "error";
            responseObj.errormessage = "No user data found!";
        } else {
            responseObj.status = "success";
            responseObj.errormessage = "";
        }
        
        return responseObj;       
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "confirmOrder")
    public ProcessedOrdersBean confirmOrder(@WebParam(name = "purchaseOrder") ProcessedOrdersBean purchaseOrder, @WebParam(name = "paymentInfo") Boolean paymentInfo) {
        //TODO write your implementation code here:
        ProcessedOrdersBean responseObj = new ProcessedOrdersBean();
        
        OrderDao dao = new OrderDao();
        
        responseObj =  dao.confirmOrder(purchaseOrder, paymentInfo);
        
        //if confirming order fails then set error to show on front end
        if(responseObj==null) {
            responseObj.status = "error";
            responseObj.errormessage = "No user data found!";
        } else {
            responseObj.status = "success";
            responseObj.errormessage = "";
        }
        
        return responseObj;    
    }
}
