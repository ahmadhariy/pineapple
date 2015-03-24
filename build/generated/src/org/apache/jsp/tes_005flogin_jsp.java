package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tes_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <!--------------------\n");
      out.write("        LOGIN FORM\n");
      out.write("        by: Amit Jakhu\n");
      out.write("        www.amitjakhu.com\n");
      out.write("        --------------------->\n");
      out.write("\n");
      out.write("        <!--META-->\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <title>Login Form</title>\n");
      out.write("\n");
      out.write("        <!--STYLESHEETS-->\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("        <!--SCRIPTS-->\n");
      out.write("        <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js\"></script>\n");
      out.write("        <!--Slider-in icons-->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\".username\").focus(function () {\n");
      out.write("                    $(\".user-icon\").css(\"left\", \"-48px\");\n");
      out.write("                });\n");
      out.write("                $(\".username\").blur(function () {\n");
      out.write("                    $(\".user-icon\").css(\"left\", \"0px\");\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $(\".password\").focus(function () {\n");
      out.write("                    $(\".pass-icon\").css(\"left\", \"-48px\");\n");
      out.write("                });\n");
      out.write("                $(\".password\").blur(function () {\n");
      out.write("                    $(\".pass-icon\").css(\"left\", \"0px\");\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!--WRAPPER-->\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("            <!--SLIDE-IN ICONS-->\n");
      out.write("            <div class=\"user-icon\"></div>\n");
      out.write("            <div class=\"pass-icon\"></div>\n");
      out.write("            <!--END SLIDE-IN ICONS-->\n");
      out.write("\n");
      out.write("            <!--LOGIN FORM-->\n");
      out.write("            <form name=\"login-form\" class=\"login-form\" action=\"\" method=\"post\">\n");
      out.write("\n");
      out.write("                <!--HEADER-->\n");
      out.write("                <div class=\"header\">\n");
      out.write("                    <!--TITLE--><h1>Login Form</h1><!--END TITLE-->\n");
      out.write("                    <!--DESCRIPTION--><span>Fill out the form below to login to my super awesome imaginary control panel.</span><!--END DESCRIPTION-->\n");
      out.write("                </div>\n");
      out.write("                <!--END HEADER-->\n");
      out.write("\n");
      out.write("                <!--CONTENT-->\n");
      out.write("                <div class=\"content\">\n");
      out.write("                    <!--USERNAME--><input name=\"username\" type=\"text\" class=\"input username\" value=\"Username\" onfocus=\"this.value = ''\" /><!--END USERNAME-->\n");
      out.write("                    <!--PASSWORD--><input name=\"password\" type=\"password\" class=\"input password\" value=\"Password\" onfocus=\"this.value = ''\" /><!--END PASSWORD-->\n");
      out.write("                </div>\n");
      out.write("                <!--END CONTENT-->\n");
      out.write("\n");
      out.write("                <!--FOOTER-->\n");
      out.write("                <div class=\"footer\">\n");
      out.write("                    <input type=\"submit\" name=\"submit\" value=\"Login\" class=\"button\" />\n");
      out.write("\n");
      out.write("                    <!--LOGIN BUTTON--><!--END LOGIN BUTTON-->\n");
      out.write("                    <!--REGISTER BUTTON--><!--END REGISTER BUTTON-->\n");
      out.write("                </div>\n");
      out.write("                <!--END FOOTER-->\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            <!--END LOGIN FORM-->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!--END WRAPPER-->\n");
      out.write("\n");
      out.write("        <!--GRADIENT--><div class=\"gradient\"></div><!--END GRADIENT-->\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
