/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.dao;
import com.cdstoreserver.SystemLogger;
import com.cdstoreserver.dbagent.DbAgentUtil;
import com.cdstoreserver.dbagent.ShopDbAgent;
import com.cdstoreserver.dbagent.beans.AddressBean;
import com.cdstoreserver.dbagent.beans.CdBean;
import com.cdstoreserver.dbagent.beans.ProcessedOrdersBean;
import com.cdstoreserver.dbagent.dao.keys.ProcessedOrderTableKeys;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import com.cdstoreserver.dbagent.dao.AddressDao;



/**
 *
 * @author Utkarsh
 * Desc:It's class which performs data access operations on ordermains and orderitemsmain tables 
 */
public class OrderDao {
    
    static String ORDERED="Ordered";
    static String PROCESSED="Processed";
    static String DENIED="Denied";
    
    ShopDbAgent objDb = null;
    

    public OrderDao() {
        objDb = new ShopDbAgent();
        
    }
    
    /*
     * Param: list of cdbeans,adressbean
     * Return: processed order bean
     * Desc: function to create order from shopping card and address info
     * 
     */
    public ProcessedOrdersBean createOrder(ArrayList<CdBean> shoppingCartInfo,AddressBean shippingInfo){
        
        AddressDao dao = new AddressDao();
        ProcessedOrdersBean returnOrder = new ProcessedOrdersBean();       
        
        
        try{
            //starting the transaction
            objDb.startTransaction();
            
            
            //Adding Address
            int intAddressId = dao.addAddress(shippingInfo);
            if(intAddressId==0){
                throw new Exception();
            }
            
            String[] orderValues = new String[]{""+shippingInfo.getUserId(),""+intAddressId,ORDERED};
            //Adding order
            int intOrderId = objDb.executeSQL("q3.1",orderValues);
            
            if(intOrderId==0){
                throw new Exception();
            } else {
                
                returnOrder.setOrderId(intOrderId);
                returnOrder.setOrderStatus(ORDERED);
                
                
            }
            
            for(int i=0;i<shoppingCartInfo.size();i++){
                
                String[] itemValues = new String[]{""+shoppingCartInfo.get(i).getCdId(),""+shoppingCartInfo.get(i).getCdPrice(),""+intOrderId};
                //Adding items
                int itemId = objDb.executeSQL("q4.1",itemValues);
                if(itemId==0){
                throw new Exception();
                }
            }
            
           
            
        } catch (Exception e) {
                
                try {
                    //if any error occurs roll back transaction
                    objDb.rollBack();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            } finally {
                try {
                    //if everything works well commit transaction
                    objDb.endTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        
        
        return returnOrder;
    }
    
    /*
     * Param: orderbean,boolean payment
     * Return: ProcessedOrdersBean
     * Desc: function to confirm order on provided paymentinfo (true or false)
     * 
     */
    public ProcessedOrdersBean confirmOrder(ProcessedOrdersBean purchaseOrder,boolean paymentInfo){
        
        ProcessedOrdersBean returnOrder = new ProcessedOrdersBean();
        String[] orderValues = new String[]{};
       
        try{
            //starting the transaction
            objDb.startTransaction();
            if(paymentInfo){
                //if payment successful then updating order status to processed
                orderValues = new String[]{PROCESSED,""+purchaseOrder.getOrderId()};
                
                
            } else {
                //if payment is unsucessful update order status to denied
                orderValues = new String[]{DENIED,""+purchaseOrder.getOrderId()};
            }
            //Adding items
            
            int intRow = objDb.executeSQL("q3.2",orderValues);
            
            if(intRow==0){
                throw new Exception();
            } else {
                returnOrder.setOrderId(Integer.parseInt(orderValues[1]));
                returnOrder.setOrderStatus(orderValues[0]);                
            }
            
        } catch (Exception e) {
                
                try {
                    //if any error occurs roll back transaction
                    objDb.rollBack();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            } finally {
                try {
                    //if everything works well commit transaction
                    objDb.endTransaction();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return returnOrder;
    }
}
