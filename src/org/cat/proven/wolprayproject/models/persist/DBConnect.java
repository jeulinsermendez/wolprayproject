/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cat.proven.wolprayproject.models.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Connect to the database using the jdbc library.
 * 
 * @author Lewis
 */
public class DBConnect {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String PROTOCOL = "jdbc:mysql:";
    static final String HOST = "localhost";
    static final String BD_NAME = "dam2004";
    static final String USER = "dam2004";
    static final String PASSWORD = "Ew8kaer9!";
    
    private static Connection conn;
    
    public static void loadDriver() throws ClassNotFoundException {
        Class.forName(DRIVER);
    }
    
    
     /**
     * gets and returns a connection to database
     *
     * @return connection
     * @throws java.sql.SQLException
     */
    
    public static Connection getConnection() throws SQLException {
        final String BD_URL = String.format("%s//%s/%s", PROTOCOL, HOST, BD_NAME);
        if(conn == null){
            conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
        }
        
        return conn;
    }
}
