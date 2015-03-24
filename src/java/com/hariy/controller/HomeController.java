/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.controller;

import com.hariy.dao.HomeDao;
import com.hariy.dao.impl.HomeDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hari
 */
public class HomeController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeDao homeService = new HomeDaoImpl();
        homeService.prepareHome(request, response);
    }
}