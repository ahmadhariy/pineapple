/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.pagination2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author INTEL
 */
public class ConnectionFactory {

    //static reference to itself

    private static ConnectionFactory instance
            = new ConnectionFactory();
    String url = "jdbc:postgresql://localhost:5432/latihan";
    String user = "postgres";
    String password = "dbhariy";
    String driverClass = "org.postgresql.Driver";

    //private constructor
    private ConnectionFactory() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException,
            ClassNotFoundException {
        Connection connection
                = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
