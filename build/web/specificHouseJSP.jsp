<%@page import="Logical_layer.UserLogic"%>
<%@page import="Classes.Contactinformation"%>
<%@page import="Logical_layer.HouseLogic"%>
<%@page import="Classes.Notification"%>
<%@page import="Logical_layer.NotificationLogic"%>
<%@page import="Classes.User"%>
<!doctype html>
<!--[if IE 7 ]>    <html lang="en-gb" class="isie ie7 oldie no-js"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en-gb" class="isie ie8 oldie no-js"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en-gb" class="isie ie9 no-js"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<%@page import="Classes.Comment"%>
<%@page import="Classes.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Classes.House"%>
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
<link rel="stylesheet" type="text/css" href="css/css.css" />

<!-- Owl Carousel Assets -->
<link href="js/owl-carousel/owl.carousel.css" rel="stylesheet">
<link rel="stylesheet" href="css/styles.css" />
<link rel="stylesheet" href="css/rate.css" />
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
          <li><a href="HomePage.jsp" class="scroll-link">Home</a></li>
          <li class="current-menu-item"><a href="" class="scroll-link">Notifications</a>
              <% User user= (User) request.getSession().getAttribute("TheUser");
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
          
          <li><a href="viewprofile.jsp" class="scroll-link">Profile</a></li>
          <li><a href="UserAdsServlet" class="scroll-link">My Ads</a></li>
          <li><a href="searchHouse.jsp" class="scroll-link">Search</a></li>
          <li><a href="AddHouse.jsp" class="scroll-link">Add House</a></li>
          <% if (user.isIsAdmin()==true){
              
          %>
          <li><a href="viewallusers.jsp" class="scroll-link">Users</a></li>
          <li><a href="suspededHouses.jsp" class="scroll-link">suspended houses</a></li>
          <%}%>
          <li><a href="logoutServlet" class="scroll-link">LogOut</a></li>
        </ul>
      </div>
      <!--/.navbar-collapse--> 
    </nav>    <!--/.navbar--> 
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
         <% //House house = (House) application.getAttribute("house");
             ArrayList<House> houses = (ArrayList<House>) application.getAttribute("AllHouses");
             int houseID = Integer.parseInt(request.getParameter("id"));
             HouseLogic houseLogic = new HouseLogic();
             UserLogic userLogic = new UserLogic();
             int userID = houseLogic.getUser(houseID);
             Contactinformation contact = userLogic.RequestContactData(userID);
             House house = new House();
             for(int i=0; i<houses.size(); i++)
             {
                 if(houses.get(i).getHouseID() == houseID)
                 {
                     house = houses.get(i);
                 }
             }
             request.getSession().setAttribute("adID", house.getHouseID());
             
          %>
          <h2><li><%=house.getAdName() %></li></h2>
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

        <div id="map">
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
              var address = "6 october, egypt";
              geocoder.geocode({'address': address}, function (results, status) {
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
        </div>

        <script async defer
          src="https://m...content-available-to-author-only...s.com/maps/api/js?key=AIzaSyApNZIr1Y8z16FL8--iEnirsSzhZqNMqCw&callback=initMap">
        </script>           


        <div class="popup" onclick="myFunction()" ><div class="btn">Request Contacts!</div>
            <span class="popuptext" id="myPopup">Email: <%= contact.getEmail() %>
                                            <br> Phone: <%= contact.getPhonenumber() %>
            </span>
            </div>
            <br>
              <label for="comments"><h4>Comments</h4></label>

              <% ArrayList<Comment> comments = house.getComments();
                for (int i = 0; i < comments.size(); i++) {
              %>
              <p> <%=  comments.get(i).getUser().getfName()%> : <%= comments.get(i).getcomment()%></p>

              <br>
             <%}%>
             <form action="rateServlet" >
                <input class="star star-5" id="star-5" type="radio" value="5" name="star"/>
                <label class="star star-5" for="star-5"></label>
                <input class="star star-4" id="star-4" type="radio" value="4" name="star"/>
                <label class="star star-4" for="star-4"></label>
                <input class="star star-3" id="star-3" type="radio" value="3" name="star"/>
                <label class="star star-3" for="star-3"></label>
                <input class="star star-2" id="star-2" type="radio" value="2" name="star"/>
                <label class="star star-2" for="star-2"></label>
                <input class="star star-1" id="star-1" type="radio" value="1" name="star"/>
                <label class="star star-1" for="star-1"></label>
                <br>
                <input type="submit" class="btn btn-lg btn-primary" value="Rate">
              </form>

              <form method="post" action="AddCommentServlet" id="contactfrm" role="form">
                <textarea name="comment" class="form-control" id="comments" cols="3" rows="5" placeholder="Enter your Comment?" title="Please enter your message (at least 10 characters)"></textarea>
                <input type="submit"  value="Add comment"  class="btn btn-lg btn-primary">
              </form>

        </div>

            
<div class="col-md-6 col-sm-12"> 
<section id="home">
  <div class="banner-container" > 
    <div id="carousel" class="carousel slide carousel-fade" data-ride="carousel" >
        <ol class="carousel-indicators" id="list">
            
        </ol>
  <!-- Carousel items -->
  <div class="carousel-inner" id="slidePhotos">
    <div class="active item">
    </div>
    
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
  var photos = <%= house.getImages().size()%>;
  var adID = <%=house.getHouseID() %>; 
  for (var j = 0; j < photos; j++)
  {
      console.log("in imge jsp")
      if(j === 0)
      {
        $("#list").prepend("<li data-target='#carousel'" + "data-slide-to=" + j + "class='active'></li>");
        $("#slidePhotos").prepend("<div class='active item'>"
            +"<img  src='viewPhotoServlet?adID=" + adID + "&indx=" + j + "' alt='banner'/></div>");

      }
        
      else
      {
        $("#list").prepend("<li data-target='#carousel'" + "data-slide-to=" + j + "></li>");
        $("#slidePhotos").prepend("<div class='item'>"
                                 +"<img  src='viewPhotoServlet?adID=" + adID + "&indx=" + j + "' alt='banner'/></div>");

      }
        
  }
</script>
<script>

var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1;}    
  if (n < 1) {slideIndex = x.length;}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}

</script>

</body>
</html>
