package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class searchHouse_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!doctype html>\r\n");
      out.write("<!--[if IE 7 ]>    <html lang=\"en-gb\" class=\"isie ie7 oldie no-js\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8 ]>    <html lang=\"en-gb\" class=\"isie ie8 oldie no-js\"> <![endif]-->\r\n");
      out.write("<!--[if IE 9 ]>    <html lang=\"en-gb\" class=\"isie ie9 no-js\"> <![endif]-->\r\n");
      out.write("<!--[if (gt IE 9)|!(IE)]><!-->\r\n");
      out.write("<html lang=\"en-gb\" class=\"no-js\">\r\n");
      out.write("<!--<![endif]-->\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\r\n");
      out.write("<title>WebThemez - Single page website</title>\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"WebThemez\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/isotope.css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"js/fancybox/jquery.fancybox.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<link href=\"css/animate.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("<!-- Owl Carousel Assets -->\r\n");
      out.write("<link href=\"js/owl-carousel/owl.carousel.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/styles.css\" />\r\n");
      out.write("<!-- Font Awesome -->\r\n");
      out.write("<link href=\"font/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<header class=\"header\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <nav class=\"navbar navbar-inverse\" role=\"navigation\">\r\n");
      out.write("      <div class=\"navbar-header\">\r\n");
      out.write("        <button type=\"button\" id=\"nav-toggle\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#main-nav\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> </button>\r\n");
      out.write("        <a href=\"#\" class=\"navbar-brand scroll-top logo  animated bounceInLeft\"><b><i><img src=\"images/logo.png\" /></i></b></a> </div>\r\n");
      out.write("      <!--/.navbar-header-->\r\n");
      out.write("      <div id=\"main-nav\" class=\"collapse navbar-collapse\">\r\n");
      out.write("        <ul class=\"nav navbar-nav\" id=\"mainNav\">\r\n");
      out.write("          <li class=\"active\" id=\"firstLink\"><a href=\"#home\" class=\"scroll-link\">Home</a></li>\r\n");
      out.write("          <li><a href=\"#services\" class=\"scroll-link\">Services</a></li>\r\n");
      out.write("          <li><a href=\"#aboutUs\" class=\"scroll-link\">About Us</a></li>\r\n");
      out.write("          <li><a href=\"#work\" class=\"scroll-link\">Projects</a></li>\r\n");
      out.write("          <li><a href=\"#plans\" class=\"scroll-link\">Price</a></li>\r\n");
      out.write("          <li><a href=\"#team\" class=\"scroll-link\">Team</a></li>\r\n");
      out.write("          <li><a href=\"#contactUs\" class=\"scroll-link\">Contact Us</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!--/.navbar-collapse--> \r\n");
      out.write("    </nav>\r\n");
      out.write("    <!--/.navbar--> \r\n");
      out.write("  </div>\r\n");
      out.write("  <!--/.container--> \r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("<!--/.header-->\r\n");
      out.write("<div id=\"#top\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<section id=\"contactUs\" class=\"contact-parlex\">\r\n");
      out.write("  <div class=\"parlex-back\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"heading text-center\"> \r\n");
      out.write("          <!-- Heading -->\r\n");
      out.write("          <h2>Search advertisement</h2>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"row mrgn30\">\r\n");
      out.write("        <form method=\"post\" action=\"searchServlet\" id=\"contactfrm\" role=\"form\">\r\n");
      out.write("          <div class=\"col-sm-12\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"name\">advertisement Name</label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"adname\" id=\"adName\" placeholder=\"Enter name\" title=\"Please enter ad name (at least 2 characters)\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"email\">advertisement Type</label><br>\r\n");
      out.write("              <input type=\"radio\"  name=\"adType\" id=\"adType\" value=\"Rent\" >Rent<br>\r\n");
      out.write("              <input type=\"radio\"  name=\"adType\" id=\"adType\" value=\"Sell\">Sell<br>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"name\">House Type</label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"housetype\" id=\"housetype\" placeholder=\"eg.Villa, Studio, apertment\" title=\"Please enter House Type\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("             \r\n");
      out.write("             <div class=\"form-group\">\r\n");
      out.write("              <label for=\"name\">Size </label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"size\" id=\"size\" placeholder=\"Enter the Size\" title=\"Please enter the Floor\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"name\">Floor </label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"floor\" id=\"floor\" placeholder=\"Enter the floor\" title=\"Please enter the Size\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"name\">Status </label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"Status\" id=\"Status\" placeholder=\"eg.Finished/ half Finished\" title=\"Please enter Finished/ half Finished\">\r\n");
      out.write("            </div>\r\n");
      out.write("              \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"name\">Price </label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"Price\" id=\"Price\" placeholder=\"Price\" title=\"Please enter the Price of the House\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("             \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"name\">Location </label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"Location\" id=\"Location\" placeholder=\"Maryam was here B)\" title=\"Please enter the Location\">\r\n");
      out.write("            </div>\r\n");
      out.write("              \r\n");
      out.write("              <div class=\"form-group\">\r\n");
      out.write("              <label for=\"name\">Rate </label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"rate\" id=\"rate\" placeholder=\"Enter the Rate\" title=\"Please enter the Rate\">\r\n");
      out.write("            </div>\r\n");
      out.write("              <div class=\"form-group\">\r\n");
      out.write("              <label for=\"email\">Create Alert</label><br>\r\n");
      out.write("              <input type=\"radio\"  name=\"createAlert\" id=\"createAlert\" value=\"yes\" >Yes<br>\r\n");
      out.write("              <input type=\"radio\"  name=\"createAlert\" id=\"createAlert\" value=\"no\">No<br>\r\n");
      out.write("            </div>\r\n");
      out.write("    \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <button name=\"submit\" type=\"submit\" class=\"btn btn-lg btn-primary\" id=\"submit\">Search</button>  \r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"result\"></div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--/.container--> \r\n");
      out.write("  </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<section class=\"copyright\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("      <div class=\"col-sm-12 text-center\"> </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- / .row --> \r\n");
      out.write("  </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<a href=\"#top\" class=\"topHome\"><i class=\"fa fa-chevron-up fa-2x\"></i></a> \r\n");
      out.write("\r\n");
      out.write("<!--[if lte IE 8]><script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script><![endif]--> \r\n");
      out.write("<script src=\"js/modernizr-latest.js\"></script> \r\n");
      out.write("<script src=\"js/jquery-1.8.2.min.js\" type=\"text/javascript\"></script> \r\n");
      out.write("<script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script> \r\n");
      out.write("<script src=\"js/jquery.isotope.min.js\" type=\"text/javascript\"></script> \r\n");
      out.write("<script src=\"js/fancybox/jquery.fancybox.pack.js\" type=\"text/javascript\"></script> \r\n");
      out.write("<script src=\"js/jquery.nav.js\" type=\"text/javascript\"></script> \r\n");
      out.write("<script src=\"js/jquery.fittext.js\"></script> \r\n");
      out.write("<script src=\"js/waypoints.js\"></script> \r\n");
      out.write("<script src=\"js/custom.js\" type=\"text/javascript\"></script> \r\n");
      out.write("<script src=\"js/owl-carousel/owl.carousel.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
