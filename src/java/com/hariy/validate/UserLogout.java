/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.validate;

import java.io.IOException;
import java.io.PrintWriter;
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
public class UserLogout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String alert = "Successfully Logout..!";
        request.setAttribute("err", alert);
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.include(request, response);
        HttpSession session = request.getSession();
        session.invalidate();

        
    }
}
