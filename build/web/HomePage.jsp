<%-- 
    Document   : HomePage
    Created on : Dec 16, 2017, 8:20:50 PM
    Author     : lenovo
--%>

<%@page import="Classes.Notification"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logical_layer.NotificationLogic"%>
<%@page import="Classes.User"%>
<%@page import="Logical_layer.HouseLogic"%>
<%@page import="Model.HouseIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<!--[if IE 7 ]>    <html lang="en-gb" class="isie ie7 oldie no-js"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en-gb" class="isie ie8 oldie no-js"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en-gb" class="isie ie9 no-js"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en-gb" class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!--[if lt IE 9]> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
<title>WebThemez - Single page website</title>
<meta name="description" content="">
<meta name="author" content="WebThemez">
<!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<!--[if lte IE 8]>
		<script type="text/javascript" src="http://explorercanvas.googlecode.com/svn/trunk/excanvas.js"></script>
	<![endif]-->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/isotope.css" media="screen" />
<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
<link href="css/animate.css" rel="stylesheet" media="screen">
<link rel="stylesheet" type="text/css" href="css/css.css">
<!-- Owl Carousel Assets -->
<link href="js/owl-carousel/owl.carousel.css" rel="stylesheet">
<link rel="stylesheet" href="css/styles.css" />
<!-- Font Awesome -->
<link href="font/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
<header class="header">
  <div class="container">
    <nav class="navbar navbar-inverse"  role="navigation" id="primary_nav_wrap">
      <div class="navbar-header">
        
        <a href="#" class="navbar-brand scroll-top logo  animated bounceInLeft"><b><i><img src="images/logo.png" /></i></b></a> </div>
      <!--/.navbar-header-->
      <div id="main-nav" class="collapse navbar-collapse">
        <ul class="nav navbar-nav" id="mainNav">
          <li class="active" id="firstLink"><a href="#home" class="scroll-link">Home</a></li>
          <li class="current-menu-item"><a href="#services" class="scroll-link">Services</a>
              <% User user=new User("marwa", "saied", "456", 010033, "marwa@gmail", "marwas", "bkla", null);
                    NotificationLogic nio = new NotificationLogic();
                    ArrayList <Notification> newNotification = nio.selectNewNotification(user);
                    ArrayList <Notification > oldNotification =nio.selectOldNotification(user);
                    nio.updateNotification(user);
       
               %>
            <ul>
               <% 
                System.out.println(newNotification.size());
                for(int i =0 ;i<newNotification.size();i++){
                %>
              <li id ="notify"><a href="specificHouseServlet?houseID=<%= newNotification.get(i).getLink()%>"><%= newNotification.get(i).getContent()%></a></li>
              <% } %>
              <%  
                for(int i =0 ;i<oldNotification.size();i++){    
              %>
              <li id ="notify"><a href="specificHouseServlet?houseID=<%= oldNotification.get(i).getLink()%>"><%= oldNotification.get(i).getContent()%></a></li>
                
              <%}%>
            </ul>
          </li>
          <li><a href="#work" class="scroll-link">Projects</a></li>
          <li><a href="#plans" class="scroll-link">Price</a></li>
          <li><a href="#team" class="scroll-link">Team</a></li>
          <li><a href="#contactUs" class="scroll-link">Contact Us</a></li>
        </ul>
      </div>
      <!--/.navbar-collapse--> 
    </nav>
    <!--/.navbar--> 
  </div>
  <!--/.container--> 
</header>

<!--/.header-->
<div id="#top"></div>

  <!-- Carousel items -->
   

<section id="plans" class="page-section">
  <div class="container">
    <div class="heading text-center"> 
      <!-- Heading -->
      <h2>Price</h2>
      
    </div>
    <div id = "bigClass" class="row flat" value = "big class" >
      
      
        
      </div>
    </div>
        
    </div>
</section>

        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script type="text/javascript">
           
                
            $(document).ready(function(){
                $.get("HomePageServlet", null, function (houses){
                
                
              
                
                for (var i = 0; i < houses.length; i++){
                    var adName =  houses[i]["adName"] ;
                    
                    var cardNameID = 'card '  + houses[i]["adName"] + '' ;
                    var cardName = '"#card '  + houses[i]["adName"] + '"' ;
                    cardName = cardName.replace(/\s+/g, '');
                    cardNameID = cardNameID.replace(/\s+/g, '');
                     console.log(cardName);
                     
                    $("#bigClass").prepend('<div id = "'+ cardNameID +'" class="col-lg-3 col-md-3 col-sm-6 col-xs-12" ></div>');
                    $('#' + cardNameID).prepend('<ul id = "ulCard" class="plan plan4"></ul>');
                   var houseID = houses[i]["houseID"];
                    var adName = '<li class="plan-name"> ' + houses[i]["adName"] + '</li>';
                    var price = '<li class="plan-price"> ' + houses[i]["price"] + ' <strong> LE</strong> </li>';
                    var status = '<li>  Status <strong>' + houses[i]["status"] + '</strong> </li>';
                    var size = '<li> Size <strong>' + houses[i]["size"] + '</strong>  </li>';
                    var viewMore = '<li class="plan-action"> <a href="specificHouseServlet?houseID='+ houseID +'" class="btn btn-danger btn-lg">View More</a> </li>';
                    var deleteBtn = '<button name="submit" type="submit" class="btn btn-lg btn-primary"  id = "deleteBtn" value = "' + houses[i]["adName"] +'" >Delete </button>';
                    var suspendBtn = '<button name="submit" type="submit" class="btn btn-lg btn-primary"  id = "suspenedBtn" value = "' + houses[i]["adName"] +'"> Suspend</button>';

                     
                     var houseID = houses[i]["houseID"];
                     $("#ulCard").append(adName);
                     $("#ulCard").append(price);
                     $("#ulCard").append(status);
                     $("#ulCard").append(size);
                     $("#ulCard").append(viewMore);
                     
                     if(user.get)
                     $("#ulCard").append(deleteBtn);
                     $("#ulCard").append(suspendBtn);
                     
                    
                 
                
        }
              $(document).on('click', '#deleteBtn', function () {
                        
                    var adName = $(this).val();
                    var cardID = adName.replace(/\s+/g, '');
                    $.get("RemoveHouseServlet", "adName=" + adName, function () {
                        $('#card' + cardID ).remove();
                    });
                    
               });
                    
              $(document).on('click', '#suspenedBtn', function(){
                  var adName = $(this).val();
                  var cardID = adName.replace(/\s+/g, '');
                  console.log(adName);
                $.get("SuspepndHouseServlet", "adName=" + adName, function () {
                        $('#card' + cardID ).remove();
                    });
                    
              });
            });
    });
        </script>
        
        
        
        

<!--/.page-section-->
<section class="copyright">
  <div class="container">
    <div class="row">
      
    </div>
    <!-- / .row --> 
  </div>
</section>
<a href="#top" class="topHome"><i class="fa fa-chevron-up fa-2x"></i></a> 

<!--[if lte IE 8]><script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script><![endif]--> 
<script src="js/modernizr-latest.js"></script> 
<script src="js/jquery-1.8.2.min.js" type="text/javascript"></script> 
<script src="js/bootstrap.min.js" type="text/javascript"></script> 
<script src="js/jquery.isotope.min.js" type="text/javascript"></script> 
<script src="js/fancybox/jquery.fancybox.pack.js" type="text/javascript"></script> 
<script src="js/jquery.nav.js" type="text/javascript"></script> 
<script src="js/jquery.fittext.js"></script> 
<script src="js/waypoints.js"></script> 
<script src="js/custom.js" type="text/javascript"></script> 
<script src="js/owl-carousel/owl.carousel.js"></script>
</body>
</html>
