/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hari
 */
public interface HomeDao {

    public void prepareHome(HttpServletRequest request, HttpServletResponse response);
}