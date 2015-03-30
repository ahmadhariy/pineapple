/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samsonasik.paging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author INTEL
 */
public class Koneksi {

    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    public Koneksi() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/latihan", "postgres", "dbhariy");
        st = con.createStatement();
    }

    public void seleksi(String s) throws SQLException {
        rs = st.executeQuery(s);
    }

    public boolean getNext() throws SQLException {
        return rs.next();
    }

    public String getText(String t) throws SQLException {
        return rs.getString(t);
    }

    public int getInt(String t) throws Exception {
        return rs.getInt(t);
    }
}
