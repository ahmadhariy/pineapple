/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.pagination;

import com.hariy.model.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INTEL
 */
public class PagginationDao {
    Connection connection;
    Statement stmt;
    private int noOfRecords;
         
    public PagginationDao() { }
    
    private static Connection getConnection() 
            throws SQLException, 
                ClassNotFoundException 
    {
        Connection con = PagginationConn.
                getInstance().getConnection();
        return con;
    }
     
    public List<Member> viewAllEmployees(
                int offset, 
                int noOfRecords)
    {
        String query = "select userid, username, firstname, lastname, birthdate, "
                + "accbank, salary from table_member offset "
                 + offset + " limit " + noOfRecords;
        List<Member> list = new ArrayList<Member>();
        Member member = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                member = new Member();
                member.setUserid(rs.getInt("userid"));
                member.setUsername(rs.getString("username"));
                member.setFirstname(rs.getString("firstname"));
                member.setLastname(rs.getString("lastname"));
                member.setBirthdate(rs.getDate("birthdate"));
                member.setAccbank(rs.getInt("accbank"));
                member.setSalary(rs.getDouble("salary"));
                list.add(member);
            }
            
            if(rs.next())
                this.noOfRecords = rs.getInt(1);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally
        {
            try {
                if(stmt != null)
                    stmt.close();
                if(connection != null)
                    connection.close();
                } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
 
    public int getNoOfRecords() {
        return noOfRecords;
    }
}
