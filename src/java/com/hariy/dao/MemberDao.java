/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hariy.dao;

import com.hariy.model.Member;
import java.util.ArrayList;

/**
 *
 * @author Hari
 */
public interface MemberDao
{
    public Member prepareFormInsert();
    public ArrayList<Member> getListAllPerson();
    public ArrayList<Member> getListSearchById(String search);
    public ArrayList<Member> getListSearchByUsername(String search);
    public ArrayList<Member> getListSearchByFirstname(String search);
    public void deletePerson(int no);
    public void insertPerson(Member person);
    public Member prepareFormEdit(int no);
    public Member  findPerson(int no);
    public void editPerson(Member person);
    public void searchPerson(int no);
    
}