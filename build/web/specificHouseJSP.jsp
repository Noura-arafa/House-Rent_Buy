<%-- 
    Document   : specificHouseJSP
    Created on : Dec 11, 2017, 6:45:38 PM
    Author     : lenovo
--%>

<%@page import="Classes.Comment"%>
<%@page import="Classes.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Classes.House"%>
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
        <div class="col-md-6 col-sm-6">
            <ul class="listArrow">
                <% House house=(House)application.getAttribute("house");%>
                <h2><li><%=house.getAdName()%></li></h2>
                <h4><li>Type</li></h4>
                <p><%=house.getType()%></p>
                <li><h4>Description</h4>
              <p><%=house.getDescription()%></p>
              </li>
              <h4><li>For </li></h4>
                <p><%=house.getAdType()%></p>
              <h4><li>Size</li></h4>
                <p><%=house.getSize()%></p>
                <h4><li>Floor</li></h4>
                <p><%=house.getFloor()%></p>
                <h4><li>Status</li></h4>
                <p><%=house.getStatus()%></p>
                <h4><li>Location</li></h4>
                <p><%=house.getLocation()%></p>
                <h4><li>Rate</li></h4>
                <p><%=house.getRate()%></p>
                <h4><li>Price</li></h4>
                <p><%=house.getPrice()%></p>
              </ul>
        
<style>
       #map {
        height: 400px;
        width: 100%;
       }
    </style>

    <div id="map"></div>
<script>
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 10,
          center: {lat: 30.0444, lng: 31.2357}
        });
        var geocoder = new google.maps.Geocoder();
          geocodeAddress(geocoder, map);
       
      }

      function geocodeAddress(geocoder, resultsMap) {
	<%String adr=house.getLocation();%>
        var address ="<%=adr%>";
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
            });
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyApNZIr1Y8z16FL8--iEnirsSzhZqNMqCw&callback=initMap">
    </script>
						<div class="popup" onclick="myFunction()" ><div class="btn">Request Contacts!</div>
            <span class="popuptext" id="myPopup">Email:
                                            <br> Phone:
            </span>
            </div>
            <br>
              <label for="comments"><h4>Comments</h4></label>
              <% ArrayList <Comment> comments = house.getComments();
                for (int i = 0; i < comments.size(); i++){
                    %>
                    <p> <%=  comments.get(i).getUser().getfName()%> : <%= comments.get(i).getcomment()%></p>
                    
                    <br>
                <%} %>
               <form method="post" action="AddCommentServlet" id="contactfrm" role="form">
              <textarea name="comment" class="form-control" id="comments" cols="3" rows="5" placeholder="Enter your Comment?" title="Please enter your message (at least 10 characters)"></textarea>
              <input type="submit"  value="Add comment"  class="btn btn-lg btn-primary">
               </form>
            </div>
    </div>

            
<div class="col-md-6 col-sm-12"> 
<section id="home">
  <div class="banner-container"> 
    <div id="carousel" class="carousel slide carousel-fade" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carousel" data-slide-to="0" class="active"></li>
    <li data-target="#carousel" data-slide-to="1"></li>
    <li data-target="#carousel" data-slide-to="2"></li>
  </ol>
  <!-- Carousel items -->
  <div class="carousel-inner">
    <div class="active item"><img src="images/banner-bg.jpg" alt="banner" /></div>
    <div class="item"><img src="images/banner-bg2.jpg" alt="banner" /></div>
    <div class="item"><img src="images/banner-bg3.jpg" alt="banner" /></div>
  </div>
  <!-- Carousel nav -->
  <a class="carousel-control left" href="#carousel" data-slide="prev">&lsaquo;</a>
  <a class="carousel-control right" href="#carousel" data-slide="next">&rsaquo;</a>
</div>
  
  </div>  
  
  <div class="container hero-text2">
  </div>
</section>
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
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>
</body>
</html>

