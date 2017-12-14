package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddHouse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<title>WebThemez - Single page website</title>\n");
      out.write("<meta name=\"description\" content=\"\">\n");
      out.write("<meta name=\"author\" content=\"WebThemez\">\n");
      out.write("\n");
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
      out.write("\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<!--/.header-->\n");
      out.write("<div id=\"#top\"></div>\n");
      out.write("\n");
      out.write("<div><h2>Welcome User</h2></div>\n");
      out.write("\n");
      out.write("<section id=\"contactUs\" class=\"contact-parlex\">\n");
      out.write("  <div class=\"parlex-back\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"heading text-center\"> \n");
      out.write("          <!-- Heading -->\n");
      out.write("          <h2>Add advertisement</h2>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"row mrgn30\">\n");
      out.write("        <form method=\"post\" action=\"AddHouseServlet\" id=\"contactfrm\" role=\"form\">\n");
      out.write("          <div class=\"col-sm-12\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"name\">advertisement Name</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"adname\" id=\"adName\" placeholder=\"Enter name\" title=\"Please enter ad name (at least 2 characters)\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"email\">advertisement Type</label><br>\n");
      out.write("              <input type=\"radio\"  name=\"adType\" id=\"adType\" value=\"Rent\" >Rent<br>\n");
      out.write("              <input type=\"radio\"  name=\"adType\" id=\"adType\" value=\"Sell\">Sell<br>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"name\">House Type</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"housetype\" id=\"housetype\" placeholder=\"eg.Villa, Studio, apertment\" title=\"Please enter House Type\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"name\">Description</label>\n");
      out.write("              <textarea name=\"description\" class=\"form-control\" id=\"description\" cols=\"3\" rows=\"5\" placeholder=\"Enter your description?\" title=\"Please the description (at least 10 characters)\"></textarea>\n");
      out.write("            </div>\n");
      out.write("             \n");
      out.write("             <div class=\"form-group\">\n");
      out.write("              <label for=\"name\">Size </label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"size\" id=\"size\" placeholder=\"Enter the Size\" title=\"Please enter the Floor\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"name\">Floor </label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"floor\" id=\"floor\" placeholder=\"Enter the floor\" title=\"Please enter the Size\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"name\">Status </label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"Status\" id=\"Status\" placeholder=\"eg.Finished/ half Finished\" title=\"Please enter Finished/ half Finished\">\n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"name\">Price </label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"Price\" id=\"Price\" placeholder=\"Price\" title=\"Please enter the Price of the House\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("              <form action=\"\"  enctype=\"multipart/form-data\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"email\">Add Photos</label><br>\n");
      out.write("              <input type=\"radio\"  name=\"addPhoto\" id=\"addPhoto\" value=\"Yes\" >Yes<br>\n");
      out.write("              <input type=\"radio\"  name=\"addPhoto\" id=\"addPhoto\" value=\"No\">No<br>\n");
      out.write("            </div>\n");
      out.write("              </form>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"name\">Location </label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"Location\" id=\"Location\" placeholder=\"By Maryam\" title=\"Please enter the Location\">\n");
      out.write("            </div>\n");
      out.write("    \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <button name=\"submit\" type=\"submit\" class=\"btn btn-lg btn-primary\" id=\"submit\">Submit</button>  \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"result\"></div>\n");
      out.write("          </div>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!--/.container--> \n");
      out.write("  </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("\n");
      out.write("<section class=\"copyright\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-sm-12 text-center\"> </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- / .row --> \n");
      out.write("  </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("\n");
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
