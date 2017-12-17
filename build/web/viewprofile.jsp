<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="Classes.User"%>
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
<!-- Owl Carousel Assets -->
<link href="js/owl-carousel/owl.carousel.css" rel="stylesheet">
<link rel="stylesheet" href="css/styles.css" />
<!-- Font Awesome -->
<link href="font/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
<header class="header">
  <div class="container">
    <nav class="navbar navbar-inverse" role="navigation">
      <div class="navbar-header">
        <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>

        <%
       
      //  HttpSession thesession=(HttpSession) application.getAttribute("thesession"); 
      System.out.println("fy al viewprofile ");
        User Theuser=(User) request.getSession().getAttribute("TheUser");
        
        //System.out.println("view the name"+Theuser.getAddress());
        String fname=Theuser.getfName();
        if(fname.equals(null)){
            fname="";
        }
        String ln= Theuser.getlName();
        if(ln==null){
            ln="";
        }
        String email=Theuser.getemail();
        if(email==null){
            email="";
        }
        String address=Theuser.getAddress();
        if(address== null){
            address="";
        }
         int phonenumber=Theuser.getphoneNumber();
                    String phonenum="";
                    if(phonenumber!=0){
                        phonenum=Integer.toString(phonenumber);
                    }
        request.setAttribute("theuserid",Theuser.getuserName());
        %>
       <a href="#" class="navbar-brand scroll-top logo  animated bounceInLeft"><b><i><img src="images/logo.png" /></i></b></a> </div> 
      <!--/.navbar-header-->
      <div id="main-nav" class="collapse navbar-collapse">
        <ul class="nav navbar-nav" id="mainNav">
          <li class="active" id="firstLink"><a href="#home" class="scroll-link">Home</a></li>
          <li><a href="#services" class="scroll-link">Services</a></li>
          <li><a href="#aboutUs" class="scroll-link">About Us</a></li>
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
<script>
// When the user clicks on <div>, open the popup
function myFunction() {
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
}
</script>
<section id="aboutUs">
  <div class="container">
    <div class="heading text-center"> 
      <!-- Heading -->
      <h2>About Us</h2>
    </div>
  
    <div class="row dataTxt">	
            <div class="outter"><img src="Getimageservlet" class="image-circle"/></div> 
						<div class="col-md-6 col-sm-6">
              <h1>Hi <%= fname    %>  </h1>
            <ul class="listArrow">
               
                <h4><li><%= fname %> 
                        <%= " " %>
                        <%=ln%></li></h4>
                <p></p>
                <h4><li><%=email%> </li></h4>
                <p></p>
                <h4><li><%= address%></li></h4>
                <p></p>
                <h4><li><%=phonenum%></li></h4>
                <p></p>
              </ul>
						
            <br>
              <input class="btn btn-lg btn-primary" id="submit" type="button" onclick="location.href='Editprofile.jsp'" name="" value="
              Edit Profile">
              <input class="btn btn-lg btn-primary" id="submit" type="button" onclick="location.href='Changepassword.jsp?username=<%=""%>'" name="" value="
              change Password">

						</div>

            
<div class="col-md-6 col-sm-12"> 

  </div>
</section> 

<!--/.page-section-->
<section class="copyright">
  <div class="container">
    <div class="row">
      <div class="col-sm-12 text-center"> </div>
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
<script>

</script>
</body>
</html>
