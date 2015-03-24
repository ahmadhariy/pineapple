/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hari
 */
public class ConnectionUtil
{
    public static Connection getConnection()
    {
        Connection conn = null;
        try
        {
            Class.forName( "org.postgresql.Driver" );
            String url = "jdbc:postgresql://localhost:5432/latihan";
            String user = "postgres";
            String pass = "dbhariy";
            conn = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException cnfe)
        {
            System.err.println("Class error :  " + cnfe.getMessage());
        }
        catch (SQLException se)
        {
            System.err.println("SQL error : " + se.getMessage());
        }
        catch (Exception e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        return conn;
    }
}