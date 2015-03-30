/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.controller;

import com.hariy.dao.HomeDao;
import com.hariy.dao.MemberDao;
import com.hariy.dao.impl.HomeDaoImpl;
import com.hariy.dao.impl.MemberDaoImpl;
import com.hariy.model.Member;
import com.hariy.util.ConnectionUtil;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hari
 */
public class MemberController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDao personService = new MemberDaoImpl(ConnectionUtil.getConnection());
        String act = request.getParameter("act");
        String no = request.getParameter("no");
        if (act.equals("insert")) {
            Member person = personService.prepareFormInsert();
            request.setAttribute("person", person);
            RequestDispatcher rd = request.getRequestDispatcher("person.jsp");
            rd.forward(request, response);
        }
        if (act.equals("edit")) {
            Member person = personService.prepareFormEdit(Integer.parseInt(no));
            request.setAttribute("person", person);
            RequestDispatcher rd = request.getRequestDispatcher("person.jsp");
            rd.forward(request, response);
        }
        if (act.equals("delete")) {
            personService.deletePerson(Integer.parseInt(no));
            HomeDao homeService = new HomeDaoImpl();
            homeService.prepareHome(request, response);
        }
        if (act.equals("search")) {
            personService.searchPerson(Integer.parseInt(no));
            HomeDao homeService = new HomeDaoImpl();
            homeService.prepareHome(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        MemberDao personService = new MemberDaoImpl(ConnectionUtil.getConnection());
        if (type.equals("search")) {

            try {

                String searchBy = request.getParameter("searchBy");
                String search = request.getParameter("inputSearch");
                //if (type == null || type.equals("")) {
                //    String error = "<html><body onload=\"alert('Hello World')\"></body></html>";
                //    request.setAttribute("err", error);
                //}
                //int searchid = Integer.parseInt(search);

                if (search != null) {
                    if (searchBy.equals("username")) {
                        request.setAttribute("listPerson", personService.getListSearchByUsername(search));
                    } else if (searchBy.equals("firstname")) {
                        request.setAttribute("listPerson", personService.getListSearchByFirstname(search));
                    } else if (searchBy.equals("userid")) {
                        request.setAttribute("listPerson", personService.getListSearchById(search));
                    } //else {
                    //  String error = "<html><body onload=\"alert('Hello World')\"></body></html>";
                    //  request.setAttribute("err", error);
                    // }
                } else {
                    request.setAttribute("listPerson", personService.getListAllPerson());
                }




                RequestDispatcher view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }


            //this search code
            //HomeDao homeService = new HomeDaoImpl();
            //homeService.prepareHome(request, response);
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


            String userid = request.getParameter("userid");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String bdate = request.getParameter("birthdate");
            String accbank = request.getParameter("accbank");
            String salary = request.getParameter("salary");



            Member person = new Member();
            person.setUserid(Integer.parseInt(userid));
            person.setUsername(username);
            person.setPassword(password);
            person.setFirstname(firstname);
            person.setLastname(lastname);
            try {
                Date xxx = (Date) formatter.parse(bdate);
                person.setBirthdate(xxx);
            } catch (ParseException ex) {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
            }
            person.setAccbank(Integer.parseInt(accbank));
            person.setSalary(Double.parseDouble(salary));

            

            if (type.equals("insert")) {
                personService.insertPerson(person);
            } else if (type.equals("edit")) {
                personService.editPerson(person);
            }

            HomeDao homeService = new HomeDaoImpl();
            homeService.prepareHome(request, response);
        }
    }
}