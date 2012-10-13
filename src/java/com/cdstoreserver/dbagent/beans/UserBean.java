/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent.beans;

/**
 *
 * @author Vaibhav
 */
public class UserBean {
    
    int userId;
    String firstName;
    String lastName;
    String email;
    String password;
    String role;
    String cardtype;
    String cardnumber;
    int cvv;
    String expdate;
    boolean isActive;
    String createdDate;
    String modifiedDate;
    public String status = "";
    public String errormessage = "";
    
    public UserBean() {
        
    }

    public UserBean(int userId, String firstName, String lastName, String email, String password, String role,String cardtype,String cardnumber,int cvv,String expdate,boolean isActive, String createdDate, String modifiedDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.cardnumber = cardnumber;
        this.cardtype = cardtype;
        this.cvv = cvv;
        this.expdate = expdate;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getCardNumber() {
        return cardnumber;
    }

    public void setCardNumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
    
    public String getCardType() {
        return cardtype;
    }

    public void setCardType(String cardtype) {
        this.cardtype = cardtype;
    }
    
    
    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    
    public String getExpDate() {
        return expdate;
    }

    public void setExpDate(String expdate) {
        this.expdate = expdate;
    }
    
    

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
}
