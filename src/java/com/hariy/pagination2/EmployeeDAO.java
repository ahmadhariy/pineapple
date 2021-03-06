/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.pagination2;

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
public class EmployeeDAO {
    Connection connection;
    Statement stmt;
    private int limit;
         
    public EmployeeDAO() { }
     
    private static Connection getConnection() 
            throws SQLException, 
                ClassNotFoundException 
    {
        Connection con = ConnectionFactory.
                getInstance().getConnection();
        return con;
    }
     
    public List<Employee> viewAllEmployees(
                int offset, 
                int limit)
    {
        String query = "select * from paging order by emp_id limit "
                 + limit + " offset " + offset;
        List<Employee> list = new ArrayList<Employee>();
        Employee employee = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                employee = new Employee();
                employee.setEmployeeId(rs.getInt("emp_id"));
                employee.setEmployeeName(rs.getString("emp_name"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDeptName(rs.getString("dept_name"));
                list.add(employee);
            }
            rs.close();
             
            rs = stmt.executeQuery("select count(*) from paging");
            if(rs.next())
                this.limit = rs.getInt(1);
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
        return limit;
    }
}