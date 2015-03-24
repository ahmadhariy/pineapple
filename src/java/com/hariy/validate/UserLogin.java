/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.validate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hari
 */
public class UserLogin extends HttpServlet {

    //String username = "123";
    //String password = "123";
    //String tes = "global";
    public boolean login(String username, String password) {
        boolean st = false;

        String url = "jdbc:postgresql://localhost:5432/latihan";
        String user = "postgres";
        String pass = "dbhariy";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = conn.prepareStatement("select * from table_user where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
            out.print("ADA SESSION");
        } else {
            out.print("TIDAK ADA SESSION");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (login(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("login", username);
            PrintWriter out = response.getWriter();
            //out.println("Counter: " + this.tes);
            Integer hitCount = (Integer) getServletContext().getAttribute("counter");

            if (hitCount == null) {
                hitCount = new Integer(1);
            } else {
                hitCount = new Integer(hitCount.intValue() + 1);
            }

            getServletContext().setAttribute("counter", hitCount);

            RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
            rd.include(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body onload=\"alert('Incorrect username and password!!')\"></body></html>");

        }
    }
}
