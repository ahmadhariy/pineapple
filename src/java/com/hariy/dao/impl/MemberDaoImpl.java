/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.dao.impl;

import com.hariy.dao.MemberDao;
import com.hariy.model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hari
 */
public class MemberDaoImpl implements MemberDao {

    private Connection connection;

    public MemberDaoImpl(Connection connection) {
        try {
            this.connection = connection;
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // berfungsi untuk mengambil seluruh data person yang ada di database.
    @Override
    public ArrayList<Member> getListAllPerson() {
        ArrayList<Member> result = new ArrayList<Member>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from table_member order by userid asc");
            while (rs.next()) {
                Member person = new Member();
                person.setUserid(rs.getInt("userid"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthdate(rs.getDate("birthdate"));
                person.setAccbank(rs.getInt("accbank"));
                person.setSalary(rs.getDouble("salary"));
                result.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<Member> getListSearchById(String username) {
        ArrayList<Member> pid_list = new ArrayList<Member>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from table_member where userid::text like '%" + username + "%' order by userid asc");
            while (rs.next()) {
                Member person = new Member();
                person.setUserid(rs.getInt("userid"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthdate(rs.getDate("birthdate"));
                person.setAccbank(rs.getInt("accbank"));
                person.setSalary(rs.getDouble("salary"));
                pid_list.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pid_list;
    }

    @Override
    public ArrayList<Member> getListSearchByUsername(String username) {
        ArrayList<Member> pid_list = new ArrayList<Member>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from table_member where username like '%" + username + "%' order by userid asc");
            while (rs.next()) {
                Member person = new Member();
                person.setUserid(rs.getInt("userid"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthdate(rs.getDate("birthdate"));
                person.setAccbank(rs.getInt("accbank"));
                person.setSalary(rs.getDouble("salary"));
                pid_list.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pid_list;
    }

    @Override
    public ArrayList<Member> getListSearchByFirstname(String search) {
        ArrayList<Member> pid_list = new ArrayList<Member>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from table_member where firstname like '%" + search + "%' ");
            while (rs.next()) {
                Member person = new Member();
                person.setUserid(rs.getInt("userid"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthdate(rs.getDate("birthdate"));
                person.setAccbank(rs.getInt("accbank"));
                person.setSalary(rs.getDouble("salary"));
                pid_list.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pid_list;
    }
    //befungsi untuk mengapus data person berdasarkan nomor tertentu

    @Override
    public void deletePerson(int no) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate("delete from table_member where userid=" + no);
            connection.commit();          
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //befungsi untuk mendapatkan nomor terakhir di database, dan ditambah dengan 1 untuk menjadi
    //nomor yang akan diinsert ke  field no untuk data baru.
    private int getLastNo() {
        Statement stmt = null;
        ResultSet rs = null;
        int result = 0;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select userid from table_member order by userid desc limit 1");
            if (rs.next()) {
                result = rs.getInt("userid");
                result += 1;
            } else {
                result = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }

    //berfungsi untuk melakukan insert data person ke database
    @Override
    public void insertPerson(Member person) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into table_member(userid, username, password, firstname, lastname, birthdate, accbank, salary) values(?,?,?,?,?,?,?,?)");
            ps.setInt(1, person.getUserid());
            ps.setString(2, person.getUsername());
            ps.setString(3, person.getPassword());
            ps.setString(4, person.getFirstname());
            ps.setString(5, person.getLastname());
            ps.setDate(6, new java.sql.Date(person.getBirthdate().getTime()));
            ps.setInt(7, person.getAccbank());
            ps.setDouble(8, person.getSalary());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //berfungsi untuk mempersiapkan data person saat hendak menambah data baru.
    @Override
    public Member prepareFormInsert() {
        Member person = new Member();
        person.setUserid(getLastNo());
        person.setType("insert");
        person.setUsername("Username");
        person.setPassword("Password");
        person.setFirstname("First Name");
        person.setLastname("Last Name");
        //person.setBirthdate(null);

        String x = "YYYY-MM-DD";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        try {
            date = formatter.parse(x);
            person.setBirthdate(date);
        } catch (ParseException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        person.setAccbank(Integer.parseInt("0"));
        person.setSalary(Double.parseDouble("0"));

        return person;
    }

    //berfungsi untuk mempersiapkan data person saat hendak mengubah data
    @Override
    public Member prepareFormEdit(int no) {
        Member person = findPerson(no);
        return person;
    }

    //berfungsi untuk mencari data person di database
    @Override
    public Member findPerson(int no) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Member person = new Member();
        try {
            ps = connection.prepareStatement("select username, password, firstname, lastname, birthdate, accbank, salary from table_member where userid=?");
            ps.setInt(1, no);
            rs = ps.executeQuery();
            if (rs.next()) {
                person.setUserid(no);
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthdate(rs.getDate("birthdate"));
                person.setAccbank(rs.getInt("accbank"));
                person.setSalary(rs.getDouble("salary"));
                person.setType("edit");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return person;

    }

    //berfungsi untuk mengedit data person di database
    @Override
    public void editPerson(Member person) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("update table_member set username=?, password=?, firstname=?, lastname=?, birthdate=?, accbank=?, salary=? where userid=?");
            ps.setString(1, person.getUsername());
            ps.setString(2, person.getPassword());
            ps.setString(3, person.getFirstname());
            ps.setString(4, person.getLastname());
            ps.setObject(5, new java.sql.Date(person.getBirthdate().getTime()));
            ps.setInt(6, person.getAccbank());
            ps.setDouble(7, person.getSalary());
            ps.setInt(8, person.getUserid());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void searchPerson(int no) {
        ArrayList<Member> result = new ArrayList<Member>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from table_member where username =" + no);
            while (rs.next()) {
                Member person = new Member();
                person.setUserid(rs.getInt("userid"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthdate(rs.getDate("birthdate"));
                person.setAccbank(rs.getInt("accbank"));
                person.setSalary(rs.getDouble("salary"));
                result.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MemberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}