/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samsonasik.paging;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author INTEL
 */
public class Orang {

    private int id;
    private String nama, alamat;

    public Orang() {
    }

    public Orang(int id, String n, String a) {
        this.id = id;
        this.nama = n;
        this.alamat = a;
    }

    public void setNama(String n) {
        this.nama = n;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAlamat(String al) {
        this.alamat = al;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    //seleksi offset limit
    public ArrayList<Orang> seleksi(int offset, int limit) throws SQLException, ClassNotFoundException {

        ArrayList<Orang> temp = new ArrayList<Orang>();
        try {
            Koneksi kon = new Koneksi();
            kon.seleksi("select * from samsonasik offset '" + offset + "' limit '" + limit + "'");

            while (kon.getNext()) {
                temp.add(new Orang(kon.getInt("id"), kon.getText("nama"), kon.getText("alamat")));
            }
        } catch (Exception e) {
        }

        return temp;
    }

    public int getJml() {
        int jml = 0;
        try {
            Koneksi kon = new Koneksi();
            kon.seleksi("select count(*) as jml from orang");
            if (kon.getNext()) {
                jml = kon.getInt("jml");
            }
        } catch (Exception e) {
        }
        return jml;
    }
}
