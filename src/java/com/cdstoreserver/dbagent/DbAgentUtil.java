/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author Vaibhav
 */
public class DbAgentUtil {

    public static String commonProperties = "db.properties";
    
    public String queryPropertyFile = "";

    public String getProperty(String propName) {
        Properties prop = new Properties();
        InputStream inputStream = ShopDbConnectionPool.class.getClassLoader().getResourceAsStream("./db.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error reading properties.Error" + e);
        }

        String propValue = prop.getProperty(propName);
        return propValue;
    }

    public String getProperty(String perpertyFileName, String propName) {
        Properties prop = new Properties();
        InputStream inputStream = ShopDbConnectionPool.class.getClassLoader().getResourceAsStream("./" + perpertyFileName);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error reading properties.Error" + e);
        }
        String propValue = prop.getProperty(propName);
        return propValue;
    }
    
    public String [] getAllProperties(String propertyFileName) {
        Properties prop = new Properties();
        InputStream inputStream = ShopDbConnectionPool.class.getClassLoader().getResourceAsStream("./" + propertyFileName);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error reading properties.Error" + e);
        }
        Set keySet = prop.keySet();
        String [] keyValues = new String[keySet.size()];
        Iterator keyIterator = keySet.iterator();
        int count=0;
        while(keyIterator.hasNext()){
            keyValues[count] = new String();
            keyValues[count++] = (String) keyIterator.next();
        }
        return keyValues;
    }
    
    public String getQuery(String queryNumber) {
        Properties prop = new Properties();
        InputStream inputStream = ShopDbConnectionPool.class.getClassLoader().getResourceAsStream("./dbquery.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error reading properties.Error" + e);
        }

        String propValue = prop.getProperty(queryNumber);
        return propValue;
    }
}
