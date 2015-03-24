/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.dao.impl;

import com.hariy.dao.HomeDao;
import com.hariy.dao.MemberDao;
import com.hariy.util.ConnectionUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hari
 */
public class HomeDaoImpl implements HomeDao
{
 
    @Override
    public void prepareHome(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            MemberDao personService = new MemberDaoImpl(ConnectionUtil.getConnection());
            //request.setAttribute("listPerson", personService.getListAllPerson());
            String username = "";
            request.setAttribute("listPerson", personService.getListSearchByUsername(username));
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(HomeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}