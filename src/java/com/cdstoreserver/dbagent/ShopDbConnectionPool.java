/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdstoreserver.dbagent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author Utkarsh
 * Class to retrieve database connection object copied from provided code on course web-site for implementing connection pooling
 */
public class ShopDbConnectionPool {
    
    DbAgentUtil objProp = null;
    /**
     * Method getConnection. Used from connection pooling example provided on course web-site.
     *
     * @return Connection object
     */
    public Connection getConnection() throws SQLException {
        Connection con = null;
        objProp = new DbAgentUtil();
        try {
            /*Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource)envContext.lookup(this.getProperty("context"));
            //DataSource dataSource = (DataSource) context.lookup(this.getProperty("context"));*/
            InitialContext ctx = new InitialContext();

            DataSource dataSource = (DataSource) ctx.lookup("jdbc/ecommerce");

            con = dataSource.getConnection();
            System.out.println("Datasource registered in JNDI is in use.");
        } catch (NamingException e) {
            
            // DataSource JNDI config failed, use DriverManager instead
            try {
                // Set the system property, without this the initialContext
                // throws an error.
                Class.forName(objProp.getProperty("driver"));
            } catch (ClassNotFoundException ex) {
                // throw new RuntimeException("JDBC Driver class not found.",
                // exp);
                System.err.println("JDBC Driver class not found.");
            }
            String connection = objProp.getProperty("url");
            String user = objProp.getProperty("user");
            String pass = objProp.getProperty("password");
            con = DriverManager.getConnection(connection, // url
                    user, // user of connection
                    pass// your password
                    );
        }
        return con;
    }
    
    
}
