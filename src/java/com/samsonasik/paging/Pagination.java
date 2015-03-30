/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samsonasik.paging;

/**
 *
 * @author INTEL
 */
public class Pagination {

    public int totalrows = 10;
    public int numlink = 2;
    public int curpage = 0;
    public int perpage = 10;
    public String firstlink = "First";
    public String nextlink = "Next";
    public String prevlink = "Previous";
    public String lastlink = "Last";

    public String createlinks(int halaman) {
        if ((this.totalrows == 0) || (this.perpage == 0)) {
            return "";
        }

        int numpage = this.totalrows / this.perpage;
        int sisa = this.totalrows % this.perpage;
        if (sisa > 0) {
            numpage = numpage + 1;
        }

        if (numpage == 1) {
            return "";
        }

        try {
            this.curpage = halaman;
        } catch (Exception e) {
            this.curpage = 1;
        }

        try {
            this.curpage = (int) this.curpage;
        } catch (Exception e) {
            this.curpage = 1;
        }

        if (this.curpage > this.totalrows) {
            this.curpage = (numpage - 1) * this.perpage;
        }

        if (this.curpage < 1) {
            this.curpage = 1;
        }

        int uri_page_number = this.curpage;
        int start = ((this.curpage - this.numlink) > 0) ? this.curpage - (this.numlink - 1) : 1;
        int end = ((this.curpage + this.numlink < numpage)) ? this.curpage + this.numlink : numpage;

        //inisialisasi ...
        String theoutput = "";
        //Render first link
        if (this.curpage > (this.numlink + 1)) {
            if (this.curpage <= numpage) {
                theoutput += "<a href=\"?page=1\">" + this.firstlink + "</a>&nbsp;";
            } else {
                theoutput += "";
            }
        }

        //Render Previous Link
        if (this.curpage != 1) {
            if (this.curpage <= numpage) {
                theoutput += "<a href=\"?page=" + (this.curpage - 1) + "\">" + this.prevlink + "</a>&nbsp;";
            } else {
                theoutput += "";
            }
        }

        //render digit link
        for (int loop = start - 1; loop < end; loop++) {
            if (this.curpage <= numpage) {
                if (this.curpage == (loop + 1)) {
                    theoutput += loop + 1 + "&nbsp;";
                } else {
                    theoutput += "<a href=\"?page=" + (loop + 1) + "\">" + (loop + 1) + "</a>&nbsp;";
                }
            } else {
                theoutput += "";

            }
        }

        //render the next link
        if (this.curpage < numpage) {
            theoutput += "<a href=\"?page=" + (this.curpage + 1) + "\">" + this.nextlink + "</a>&nbsp;";
        } else {
            theoutput += "";
        }

        //render the last link
        if ((this.curpage + this.numlink) < numpage) {
            theoutput += "<a href=\"?page=" + numpage + "\">" + this.lastlink + "</a>";
        }

        return theoutput;
    }
}
