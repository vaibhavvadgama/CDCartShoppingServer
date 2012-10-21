/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Vaibhav
 * System Logger class is implemented for logging various errors from different 
 * classes it prints various errors,warnings or messages on prompt mostly it is useful while debugging
 */
public class SystemLogger {

    public static boolean flagLog = true;
    public static String appendString = "CDStoreServer-Logger:";
    
    //function to handle severe error 
    public static void severe(String message) {
        String level = "SEVERE";
        if (flagLog == true) {
            System.err.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }
    
    //function to handle warning
    public static void warning(String message) {
        String level = "WARNING";
        if (flagLog == true) {
            System.err.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }
    
    //function to providing information while execution 
    public static void info(String message) {
        String level = "INFO";
        if (flagLog == true) {
            System.out.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }
    
    //function to print config errors or messages 
    public static void config(String message) {
        String level = "CONFIG";
        if (flagLog == true) {
            System.out.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }
   
    //function to handle fine messages 
    public static void fine(String message) {
        String level = "FINE";
        if (flagLog == true) {
            System.out.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }
    
    //function to handle general messages
    public static void err(String message) {
        String level = "ERROR";
        if (flagLog == true) {
            System.err.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }
   
    //function to print messages
    public static void out(String message) {
        String level = "OUT";
        if (flagLog == true) {
            System.out.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }
}
