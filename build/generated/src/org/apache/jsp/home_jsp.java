package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.hariy.model.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script language=\"javascript\">\n");
      out.write("            function addRecord(){\n");
      out.write("       \n");
      out.write("                window.location.href=\"Member?act=insert\"; \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function check(){\n");
      out.write("                if(!form.x.value){\n");
      out.write("                    alert (\"Please fill the keyword to search..\");\n");
      out.write("                    return (false);\n");
      out.write("                }\n");
      out.write("                return (true);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table width=\"100%\">\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"left\"><b>Welcome, ");
      out.print( session.getAttribute("login"));
      out.write("!</b></td>\n");
      out.write("                <td align=\"right\">Server time: ");
      out.print( new java.util.Date());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"left\">Do you want to <a href=\"UserLogout\">Logout</a>?</td>\n");
      out.write("                <td align=\"right\">Counter: ");
      out.print( getServletContext().getAttribute("counter"));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("            <hr>\n");
      out.write("        <br>\n");
      out.write("        <table align=\"center\">\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <br>\n");
      out.write("        <table width=\"600px\"  align=\"center\" style=\"background-color:#EDF6EA;border:1px solid #000000;\">\n");
      out.write("            <tr><td colspan=9 align=\"center\" height=\"10px\"></td></tr>\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"5\" align=\"center\"><h3>---Member Maintenance---</h3></td>\n");
      out.write("                <td colspan=\"1\" align=\"center\">Search by:</td>\n");
      out.write("                <form method=\"post\" name=\"form\" action=\"Member?act=search\">\n");
      out.write("                <td colspan=\"3\" align=\"left\">\n");
      out.write("                    <select name=\"searchBy\" id=\"searchBy\">\n");
      out.write("                        <option value=\"userid\">User ID</option>\n");
      out.write("                        <option value=\"username\">Username</option>\n");
      out.write("                        <option value=\"firstname\">Firstname</option>\n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("                </tr>\n");
      out.write("            <tr>\n");
      out.write("                <!--<td colspan=5 align=\"center\"><a href=\"memberAction.do?act=insert\" style=\"font-weight:bold;color:#cc0000;\">Add New User</a></td>-->\n");
      out.write("                <td colspan=5 align=\"center\"><input type=\"button\" name=\"submit\" value=\"Add New User\" style=\"background-color:#ff0000;font-weight:bold;color:#ffffff;\"onclick=\"addRecord();\"></td>\n");
      out.write("                <td colspan=1 align=\"center\">Keyword: </td>\n");
      out.write("            \n");
      out.write("                <td colspan=1 align=\"center\"><input type=\"text\" name=\"x\" id=\"x\" ></td><input type=\"hidden\" value=\"search\" name=\"type\" id=\"type\"/>\n");
      out.write("                <td colspan=2 align=\"center\"><input type=\"submit\" value=\"Submit\" name=\"Submit\" style=\"background-color:#49743D;font-weight:bold;color:#ffffff;\" onclick=\"return check();\"></td>\n");
      out.write("            </form>\n");
      out.write("            <!--<td colspan=0 align=\"center\"><a href=\"search.jsp\" style=\"font-weight:bold;color:#cc0000;\">Search</a></td>-->\n");
      out.write("        </tr>\n");
      out.write("        <tr><td colspan=9 align=\"center\" height=\"10px\"></td></tr>\n");
      out.write("        <tr style=\"background-color:#7BA88B;font-weight:bold;\">\n");
      out.write("            <td>User ID</td>\n");
      out.write("            <td>Username</td>\n");
      out.write("            <td>First Name</td>\n");
      out.write("            <td>Last Name</td>\n");
      out.write("            <td>Account Bank</td>\n");
      out.write("            <td>Salary</td>\n");
      out.write("            <td>Birth Date</td>\n");
      out.write("            <td>Edit</td>\n");
      out.write("            <td>Delete</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            ArrayList<Member> listMember = (ArrayList<Member>) request.getAttribute("listPerson");
            
            for (int i = 0; i < listMember.size(); i++) {

        
      out.write("\n");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( listMember.get(i).getUserid());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( listMember.get(i).getUsername());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( listMember.get(i).getFirstname());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( listMember.get(i).getLastname());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( listMember.get(i).getAccbank());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( listMember.get(i).getSalary());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( listMember.get(i).getBirthdate());
      out.write("</td>\n");
      out.write("            <td><a href=\"Member?act=edit&no=");
      out.print( listMember.get(i).getUserid());
      out.write("\">Edit</a></td>\n");
      out.write("            <td><a href=\"Member?act=delete&no=");
      out.print( listMember.get(i).getUserid());
      out.write("\">Delete</a></td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }

        
      out.write("\n");
      out.write("    </table>\n");
      out.write("</body>\n");
      out.write("</html>\n");

    String err = (String) request.getAttribute("err");

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
