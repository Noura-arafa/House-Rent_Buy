package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Classes.Notification;
import java.util.ArrayList;
import Logical_layer.NotificationLogic;
import Classes.User;
import Logical_layer.HouseLogic;
import Model.HouseIO;

public final class HomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\">\n");
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
      out.write("    <nav class=\"navbar navbar-inverse\"  role=\"navigation\" id=\"primary_nav_wrap\">\n");
      out.write("      <div class=\"navbar-header\">\n");
      out.write("        \n");
      out.write("        <a href=\"#\" class=\"navbar-brand scroll-top logo  animated bounceInLeft\"><b><i><img src=\"images/logo.png\" /></i></b></a> </div>\n");
      out.write("      <!--/.navbar-header-->\n");
      out.write("      <div id=\"main-nav\" class=\"collapse navbar-collapse\">\n");
      out.write("        <ul class=\"nav navbar-nav\" id=\"mainNav\">\n");
      out.write("          <li class=\"active\" id=\"firstLink\"><a href=\"#home\" class=\"scroll-link\">Home</a></li>\n");
      out.write("          <li class=\"current-menu-item\"><a href=\"#services\" class=\"scroll-link\">Services</a>\n");
      out.write("              ");
 User user=new User("marwa", "saied", "456", 010033, "marwa@gmail", "marwas", "bkla", null);
                    NotificationLogic nio = new NotificationLogic();
                    ArrayList <Notification> newNotification = nio.selectNewNotification(user);
                    ArrayList <Notification > oldNotification =nio.selectOldNotification(user);
                    nio.updateNotification(user);
       
               
      out.write("\n");
      out.write("            <ul>\n");
      out.write("               ");
 
                System.out.println(newNotification.size());
                for(int i =0 ;i<newNotification.size();i++){
                
      out.write("\n");
      out.write("              <li id =\"notify\"><a href=\"specificHouseServlet?houseID=");
      out.print( newNotification.get(i).getLink());
      out.write('"');
      out.write('>');
      out.print( newNotification.get(i).getContent());
      out.write("</a></li>\n");
      out.write("              ");
 } 
      out.write("\n");
      out.write("              ");
  
                for(int i =0 ;i<oldNotification.size();i++){    
              
      out.write("\n");
      out.write("              <li id =\"notify\"><a href=\"specificHouseServlet?houseID=");
      out.print( oldNotification.get(i).getLink());
      out.write('"');
      out.write('>');
      out.print( oldNotification.get(i).getContent());
      out.write("</a></li>\n");
      out.write("                \n");
      out.write("              ");
}
      out.write("\n");
      out.write("            </ul>\n");
      out.write("          </li>\n");
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
      out.write("\n");
      out.write("<!--/.header-->\n");
      out.write("<div id=\"#top\"></div>\n");
      out.write("\n");
      out.write("  <!-- Carousel items -->\n");
      out.write("   \n");
      out.write("\n");
      out.write("<section id=\"plans\" class=\"page-section\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"heading text-center\"> \n");
      out.write("      <!-- Heading -->\n");
      out.write("      <h2>Price</h2>\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("    <div id = \"bigClass\" class=\"row flat\" value = \"big class\" >\n");
      out.write("      \n");
      out.write("      \n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $.get(\"HomePageServlet\", null, function (houses){\n");
      out.write("                \n");
      out.write("                \n");
      out.write("              \n");
      out.write("                \n");
      out.write("                for (var i = 0; i < houses.length; i++){\n");
      out.write("                    var adName =  houses[i][\"adName\"] ;\n");
      out.write("                    \n");
      out.write("                    var cardNameID = 'card '  + houses[i][\"adName\"] + '' ;\n");
      out.write("                    var cardName = '\"#card '  + houses[i][\"adName\"] + '\"' ;\n");
      out.write("                    cardName = cardName.replace(/\\s+/g, '');\n");
      out.write("                    cardNameID = cardNameID.replace(/\\s+/g, '');\n");
      out.write("                     console.log(cardName);\n");
      out.write("                     \n");
      out.write("                    $(\"#bigClass\").prepend('<div id = \"'+ cardNameID +'\" class=\"col-lg-3 col-md-3 col-sm-6 col-xs-12\" ></div>');\n");
      out.write("                    $('#' + cardNameID).prepend('<ul id = \"ulCard\" class=\"plan plan4\"></ul>');\n");
      out.write("                   var houseID = houses[i][\"houseID\"];\n");
      out.write("                    var adName = '<li class=\"plan-name\"> ' + houses[i][\"adName\"] + '</li>';\n");
      out.write("                    var price = '<li class=\"plan-price\"> ' + houses[i][\"price\"] + ' <strong> LE</strong> </li>';\n");
      out.write("                    var status = '<li>  Status <strong>' + houses[i][\"status\"] + '</strong> </li>';\n");
      out.write("                    var size = '<li> Size <strong>' + houses[i][\"size\"] + '</strong>  </li>';\n");
      out.write("                    var viewMore = '<li class=\"plan-action\"> <a href=\"specificHouseServlet?houseID='+ houseID +'\" class=\"btn btn-danger btn-lg\">View More</a> </li>';\n");
      out.write("                    var deleteBtn = '<button name=\"submit\" type=\"submit\" class=\"btn btn-lg btn-primary\"  id = \"deleteBtn\" value = \"' + houses[i][\"adName\"] +'\" >Delete </button>';\n");
      out.write("                    var suspendBtn = '<button name=\"submit\" type=\"submit\" class=\"btn btn-lg btn-primary\"  id = \"suspenedBtn\" value = \"' + houses[i][\"adName\"] +'\"> Suspend</button>';\n");
      out.write("\n");
      out.write("                     \n");
      out.write("                     var houseID = houses[i][\"houseID\"];\n");
      out.write("                     $(\"#ulCard\").append(adName);\n");
      out.write("                     $(\"#ulCard\").append(price);\n");
      out.write("                     $(\"#ulCard\").append(status);\n");
      out.write("                     $(\"#ulCard\").append(size);\n");
      out.write("                     $(\"#ulCard\").append(viewMore);\n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                     $(\"#ulCard\").append(deleteBtn);\n");
      out.write("                     $(\"#ulCard\").append(suspendBtn);\n");
      out.write("                     \n");
      out.write("                    \n");
      out.write("                 \n");
      out.write("                \n");
      out.write("        }\n");
      out.write("              $(document).on('click', '#deleteBtn', function () {\n");
      out.write("                        \n");
      out.write("                    var adName = $(this).val();\n");
      out.write("                    var cardID = adName.replace(/\\s+/g, '');\n");
      out.write("                    $.get(\"RemoveHouseServlet\", \"adName=\" + adName, function () {\n");
      out.write("                        $('#card' + cardID ).remove();\n");
      out.write("                    });\n");
      out.write("                    \n");
      out.write("               });\n");
      out.write("                    \n");
      out.write("              $(document).on('click', '#suspenedBtn', function(){\n");
      out.write("                  var adName = $(this).val();\n");
      out.write("                  var cardID = adName.replace(/\\s+/g, '');\n");
      out.write("                  console.log(adName);\n");
      out.write("                $.get(\"SuspepndHouseServlet\", \"adName=\" + adName, function () {\n");
      out.write("                        $('#card' + cardID ).remove();\n");
      out.write("                    });\n");
      out.write("                    \n");
      out.write("              });\n");
      out.write("            });\n");
      out.write("    });\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("<!--/.page-section-->\n");
      out.write("<section class=\"copyright\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("      \n");
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
