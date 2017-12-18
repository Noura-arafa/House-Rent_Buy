package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Blob;
import java.io.OutputStream;
import Classes.Image;
import Classes.Image;
import Controller.UserAdsServlet;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.ArrayList;
import Classes.House;

public final class UserAds_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<!--[if IE 7 ]>    <html lang=\"en-gb\" class=\"isie ie7 oldie no-js\"> <![endif]-->\n");
      out.write("<!--[if IE 8 ]>    <html lang=\"en-gb\" class=\"isie ie8 oldie no-js\"> <![endif]-->\n");
      out.write("<!--[if IE 9 ]>    <html lang=\"en-gb\" class=\"isie ie9 no-js\"> <![endif]-->\n");
      out.write("<!--[if (gt IE 9)|!(IE)]><!-->\n");
      out.write("<html lang=\"en-gb\" class=\"no-js\">\n");
      out.write("<!--<![endif]-->\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("<!--[if lt IE 9]> \n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("    <![endif]-->\n");
      out.write("<title>WebThemez - Single page website</title>\n");
      out.write("<meta name=\"description\" content=\"\">\n");
      out.write("<meta name=\"author\" content=\"WebThemez\">\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("        <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("<!--[if lte IE 8]>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"http://explorercanvas.googlecode.com/svn/trunk/excanvas.js\"></script>\n");
      out.write("\t<![endif]-->\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/isotope.css\" media=\"screen\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"js/fancybox/jquery.fancybox.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("<link href=\"css/animate.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("<!-- Owl Carousel Assets -->\n");
      out.write("<link href=\"js/owl-carousel/owl.carousel.css\" rel=\"stylesheet\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/styles.css\" />\n");
      out.write("<!-- Font Awesome -->\n");
      out.write("<link href=\"font/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<header class=\"header\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <nav class=\"navbar navbar-inverse\" role=\"navigation\">\n");
      out.write("      <div class=\"navbar-header\">\n");
      out.write("        <button type=\"button\" id=\"nav-toggle\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#main-nav\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> </button>\n");
      out.write("        <a href=\"#\" class=\"navbar-brand scroll-top logo  animated bounceInLeft\"><b><i><img src=\"images/logo.png\" /></i></b></a> </div>\n");
      out.write("      <!--/.navbar-header-->\n");
      out.write("      <div id=\"main-nav\" class=\"collapse navbar-collapse\">\n");
      out.write("        <ul class=\"nav navbar-nav\" id=\"mainNav\">\n");
      out.write("          <li class=\"active\" id=\"firstLink\"><a href=\"#home\" class=\"scroll-link\">Home</a></li>\n");
      out.write("          <li><a href=\"#services\" class=\"scroll-link\">Services</a></li>\n");
      out.write("          <li><a href=\"#aboutUs\" class=\"scroll-link\">About Us</a></li>\n");
      out.write("          <li><a href=\"#work\" class=\"scroll-link\">Projects</a></li>\n");
      out.write("          <li><a href=\"#plans\" class=\"scroll-link\">Price</a></li>\n");
      out.write("          <li><a href=\"#team\" class=\"scroll-link\">Team</a></li>\n");
      out.write("          <li><a href=\"#contactUs\" class=\"scroll-link\">Contact Us</a></li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("      <!--/.navbar-collapse--> \n");
      out.write("    </nav>\n");
      out.write("    <!--/.navbar--> \n");
      out.write("  </div>\n");
      out.write("  <!--/.container--> \n");
      out.write("</header>\n");
      out.write("<!--/.header-->\n");
      out.write("<div id=\"#top\"></div>\n");
      out.write("\n");
      out.write("<section id=\"work\" class=\"page-section page\">\n");
      out.write("  <div class=\"container text-center\">\n");
      out.write("    <div class=\"heading\">\n");
      out.write("      <h2>Projects</h2>\n");
      out.write("      <h2>Advertisements</h2>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-md-12\">\n");
      out.write("        <div id=\"portfolio\">\n");
      out.write("          <ul class=\"filters list-inline\">\n");
      out.write("            <li> <a class=\"active\" data-filter=\"*\" href=\"#\"></a> </li>\n");
      out.write("           </ul>\n");
      out.write("            <div id=\"rowdiv\">\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("          ");
 
              ArrayList<House> userHouses = (ArrayList<House>) request.getSession().getAttribute("userHouse");
              for(int i=0; i<userHouses.size(); i++)
              {
          
      out.write("\n");
      out.write("    <div class=\"row dataTxt\" >\n");
      out.write("        <div class=\"col-md-6 col-sm-6\" >\n");
      out.write("          <ul>\n");
      out.write("              <li class=\"item branding\" style=\"position: absolute; left: 0px; top: 0px;\">\n");
      out.write("                  <h4><a herf =\"specificHouseServlet\" >");
      out.print(userHouses.get(i).getAdName() );
      out.write("</a></h4>\n");
      out.write("              </li>\n");
      out.write("                 <button name=\"submit\" type=\"submit\" class=\"btn btn-lg btn-primary\" onclick=\"location.href='editServlet?adName=");
      out.print( userHouses.get(i).getAdName());
      out.write("'\">Edit</button>\n");
      out.write("                 <button name=\"submit\" type=\"submit\" class=\"btn btn-lg btn-primary\" onclick=\"location.href='deleteHouseServlet?adName=");
      out.print( userHouses.get(i).getAdName());
      out.write("'\">Delete</button>\n");
      out.write("                 </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("      <hr width=\"100%\" size=\"8\" noshade align=\"center\">\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</section>\n");
      out.write("<!--/.page-section-->\n");
      out.write("<section class=\"LastTab\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-sm-12 text-center\"> </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- / .row --> \n");
      out.write("  </div>\n");
      out.write("</section>\n");
      out.write("<a href=\"#top\" class=\"topHome\"><i class=\"fa fa-chevron-up fa-2x\"></i></a> \n");
      out.write("\n");
      out.write("<!--[if lte IE 8]><script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script><![endif]--> \n");
      out.write("<script src=\"js/modernizr-latest.js\"></script> \n");
      out.write("<script src=\"js/jquery-1.8.2.min.js\" type=\"text/javascript\"></script> \n");
      out.write("<script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script> \n");
      out.write("<script src=\"js/jquery.isotope.min.js\" type=\"text/javascript\"></script> \n");
      out.write("<script src=\"js/fancybox/jquery.fancybox.pack.js\" type=\"text/javascript\"></script> \n");
      out.write("<script src=\"js/jquery.nav.js\" type=\"text/javascript\"></script> \n");
      out.write("<script src=\"js/jquery.fittext.js\"></script> \n");
      out.write("<script src=\"js/waypoints.js\"></script> \n");
      out.write("<script src=\"js/custom.js\" type=\"text/javascript\"></script> \n");
      out.write("<script src=\"js/owl-carousel/owl.carousel.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
