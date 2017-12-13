package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Classes.Comment;
import Classes.Comment;
import java.util.ArrayList;
import java.util.ArrayList;
import Classes.House;

public final class specificHouseJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
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
      out.write("<script>\n");
      out.write("// When the user clicks on <div>, open the popup\n");
      out.write("function myFunction() {\n");
      out.write("    var popup = document.getElementById(\"myPopup\");\n");
      out.write("    popup.classList.toggle(\"show\");\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<section id=\"aboutUs\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"heading text-center\"> \n");
      out.write("      <!-- Heading -->\n");
      out.write("      <h2>About Us</h2>\n");
      out.write("    </div>\n");
      out.write("  \n");
      out.write("    <div class=\"row dataTxt\">\t\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-6 col-sm-6\">\n");
      out.write("            <ul class=\"listArrow\">\n");
      out.write("                ");
 House house=(House)application.getAttribute("house");
      out.write("\n");
      out.write("                <h2><li>");
      out.print(house.getAdName());
      out.write("</li></h2>\n");
      out.write("                <h4><li>Type</li></h4>\n");
      out.write("                <p>");
      out.print(house.getType());
      out.write("</p>\n");
      out.write("                <li><h4>Description</h4>\n");
      out.write("              <p>");
      out.print(house.getDescription());
      out.write("</p>\n");
      out.write("              </li>\n");
      out.write("              <h4><li>For </li></h4>\n");
      out.write("                <p>");
      out.print(house.getAdType());
      out.write("</p>\n");
      out.write("              <h4><li>Size</li></h4>\n");
      out.write("                <p>");
      out.print(house.getSize());
      out.write("</p>\n");
      out.write("                <h4><li>Floor</li></h4>\n");
      out.write("                <p>");
      out.print(house.getFloor());
      out.write("</p>\n");
      out.write("                <h4><li>Status</li></h4>\n");
      out.write("                <p>");
      out.print(house.getStatus());
      out.write("</p>\n");
      out.write("                <h4><li>Location</li></h4>\n");
      out.write("                <p>");
      out.print(house.getLocation());
      out.write("</p>\n");
      out.write("                <h4><li>Rate</li></h4>\n");
      out.write("                <p>");
      out.print(house.getRate());
      out.write("</p>\n");
      out.write("                <h4><li>Price</li></h4>\n");
      out.write("                <p>");
      out.print(house.getPrice());
      out.write("</p>\n");
      out.write("              </ul>\n");
      out.write("\t\t\t\t\t\t<div class=\"popup\" onclick=\"myFunction()\" ><div class=\"btn\">Request Contacts!</div>\n");
      out.write("            <span class=\"popuptext\" id=\"myPopup\">Email:\n");
      out.write("                                            <br> Phone:\n");
      out.write("            </span>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("              <label for=\"comments\"><h4>Comments</h4></label>\n");
      out.write("              ");
 ArrayList <Comment> comments = house.getComments();
                for (int i = 0; i < comments.size(); i++){
                    
      out.write("\n");
      out.write("                    <p> ");
      out.print(  comments.get(i).getUser().getfName());
      out.write("</p>\n");
      out.write("                    <br>\n");
      out.write("                    <p>");
      out.print( comments.get(i).getcomment());
      out.write("</p>\n");
      out.write("                    <br>\n");
      out.write("                ");
} 
      out.write("\n");
      out.write("              \n");
      out.write("              <textarea name=\"comment\" class=\"form-control\" id=\"comments\" cols=\"3\" rows=\"5\" placeholder=\"Enter your message?\" title=\"Please enter your message (at least 10 characters)\"></textarea>\n");
      out.write("              <button name=\"submit\" type=\"submit\" class=\"btn btn-lg btn-primary\" id=\"submit\">Add comment</button>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("            \n");
      out.write("<div class=\"col-md-6 col-sm-12\"> \n");
      out.write("<section id=\"home\">\n");
      out.write("  <div class=\"banner-container\"> \n");
      out.write("    <div id=\"carousel\" class=\"carousel slide carousel-fade\" data-ride=\"carousel\">\n");
      out.write("  <ol class=\"carousel-indicators\">\n");
      out.write("    <li data-target=\"#carousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("    <li data-target=\"#carousel\" data-slide-to=\"1\"></li>\n");
      out.write("    <li data-target=\"#carousel\" data-slide-to=\"2\"></li>\n");
      out.write("  </ol>\n");
      out.write("  <!-- Carousel items -->\n");
      out.write("  <div class=\"carousel-inner\">\n");
      out.write("    <div class=\"active item\"><img src=\"images/banner-bg.jpg\" alt=\"banner\" /></div>\n");
      out.write("    <div class=\"item\"><img src=\"images/banner-bg2.jpg\" alt=\"banner\" /></div>\n");
      out.write("    <div class=\"item\"><img src=\"images/banner-bg3.jpg\" alt=\"banner\" /></div>\n");
      out.write("  </div>\n");
      out.write("  <!-- Carousel nav -->\n");
      out.write("  <a class=\"carousel-control left\" href=\"#carousel\" data-slide=\"prev\">&lsaquo;</a>\n");
      out.write("  <a class=\"carousel-control right\" href=\"#carousel\" data-slide=\"next\">&rsaquo;</a>\n");
      out.write("</div>\n");
      out.write("  \n");
      out.write("  </div>  \n");
      out.write("  \n");
      out.write("  <div class=\"container hero-text2\">\n");
      out.write("  </div>\n");
      out.write("</section>\n");
      out.write("  </div>\n");
      out.write("</section> \n");
      out.write("\n");
      out.write("<!--/.page-section-->\n");
      out.write("<section class=\"copyright\">\n");
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
      out.write("<script>\n");
      out.write("var slideIndex = 1;\n");
      out.write("showDivs(slideIndex);\n");
      out.write("\n");
      out.write("function plusDivs(n) {\n");
      out.write("  showDivs(slideIndex += n);\n");
      out.write("}\n");
      out.write("\n");
      out.write("function showDivs(n) {\n");
      out.write("  var i;\n");
      out.write("  var x = document.getElementsByClassName(\"mySlides\");\n");
      out.write("  if (n > x.length) {slideIndex = 1}    \n");
      out.write("  if (n < 1) {slideIndex = x.length}\n");
      out.write("  for (i = 0; i < x.length; i++) {\n");
      out.write("     x[i].style.display = \"none\";  \n");
      out.write("  }\n");
      out.write("  x[slideIndex-1].style.display = \"block\";  \n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
