/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent;

import com.cdstoreserver.SystemLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Utkarsh
 */
public class ShopDbAgent {

    Connection connection = null;
    DbAgentUtil objProp = null;
    ShopDbConnectionPool objDb = null;

    /**
     * constructor is created to initialize connection
     *
     */
    public ShopDbAgent() {

        objProp = new DbAgentUtil();
        try {
            /*creating a coonection to mysql database */
            objDb = new ShopDbConnectionPool();
            connection = objDb.getConnection();
        } catch (SQLException e) {
            System.out.println("Connection to the database failed. " + e.getMessage());
            connection = null;
        }
    }

    public void startTransaction() throws Exception {
        connection.setAutoCommit(false);
    }

    public void endTransaction() throws Exception {
        /* Commits the changes made in the database to the database. */
        connection.commit();
        /* Close the connection */
        connection.close();
    }

    public void rollBack() throws Exception {
        /* In case of an exception or error roll back the changes from database. 
         */
        connection.rollback();
    }

    /*
     * Param: string queryid , string array parameter
     * Return: Number of rows updated
     * Desc: function returns number of rows updated by insert,delete or update query
     * 
     */
    public int executeSQL(String queryId, String[] parameters) {
        int intRows = 0;
        ResultSet rs = null;
        String strSql = null;
        strSql = objProp.getQuery(queryId);
        SystemLogger.info(" SQL to be executed : " + strSql);
        SystemLogger.info("Parameters:"+parameters[0]+parameters[1]);
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(strSql,Statement.RETURN_GENERATED_KEYS);
            if (parameters!= null) {

                for (int i = 0; i < parameters.length; i++) {
                    preparedStatement.setString((i + 1), parameters[i]);

                }
            }
                intRows = preparedStatement.executeUpdate();
                rs = preparedStatement.getGeneratedKeys(); 
                if ( rs != null && rs.next() ) 
                { 
                    intRows = rs.getInt(1); 
                }           
            
        } catch (SQLException e) {
            System.out.println("Error invalid SQL syntax. " + e.getMessage());
            try {
                this.rollBack();
            } catch (SQLException ex) {
                intRows = 0;
            }
            intRows = 0;
        } finally {
            return intRows;
        }

    }

    /*
     * Param: string queryid , string array parameter
     * Return: List of associative rows
     * Desc: function returns converts resultset in to list of associative rows and returns it
     * reference: http://stackoverflow.com/questions/7507121/efficient-way-to-handle-resultset-in-java
     * 
     */
    public ResultSet getQueryResult(String queryId, String[] parameters) {
        ResultSet rs = null;
        String strSql = null;
        ArrayList arrList = new ArrayList();

        strSql = objProp.getQuery(queryId);
        SystemLogger.info(" SQL to be executed : " + queryId);
        
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(strSql);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    preparedStatement.setString((i + 1), parameters[i]);
                }
            }
            rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error invalid SQL syntax. " + e.getMessage());
            try {
                this.rollBack();
            } catch (SQLException ex) {
                arrList = null;
            }
            arrList = null;
        } finally {
            return rs;
        }
    }
}
