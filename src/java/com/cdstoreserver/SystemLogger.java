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
 */
public class SystemLogger {

    public static boolean flagLog = true;
    public static String appendString = "CDStoreServer-Logger:";

    public static void severe(String message) {
        String level = "SEVERE";
        if (flagLog == true) {
            System.err.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }

    public static void warning(String message) {
        String level = "WARNING";
        if (flagLog == true) {
            System.err.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }

    public static void info(String message) {
        String level = "INFO";
        if (flagLog == true) {
            System.out.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }

    public static void config(String message) {
        String level = "CONFIG";
        if (flagLog == true) {
            System.out.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }

    public static void fine(String message) {
        String level = "FINE";
        if (flagLog == true) {
            System.out.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }

    public static void err(String message) {
        String level = "ERROR";
        if (flagLog == true) {
            System.err.println(
                    appendString + " [" + level + "] ["
                    + DateFormat.getInstance().format(new Date()) + "] "
                    + message);
        }
    }

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
