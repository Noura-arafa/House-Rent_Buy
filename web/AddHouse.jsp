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

<title>WebThemez - Single page website</title>
<meta name="description" content="">
<meta name="author" content="WebThemez">

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

<div><h2>Welcome User</h2></div>

<section id="contactUs" class="contact-parlex">
  <div class="parlex-back">
    <div class="container">
      <div class="row">
        <div class="heading text-center"> 
          <!-- Heading -->
          <h2>Add advertisement</h2>
        </div>
      </div>
      <div class="row mrgn30">
        <form method="post" action="AddHouseServlet" id="contactfrm" role="form">
          <div class="col-sm-12">
            <div class="form-group">
              <label for="name">advertisement Name</label>
              <input type="text" class="form-control" name="adname" id="adName" placeholder="Enter name" title="Please enter ad name (at least 2 characters)">
            </div>

            <div class="form-group">
              <label for="email">advertisement Type</label><br>
              <input type="radio"  name="adType" id="adType" value="Rent" >Rent<br>
              <input type="radio"  name="adType" id="adType" value="Sell">Sell<br>
            </div>

            <div class="form-group">
              <label for="name">House Type</label>
              <input type="text" class="form-control" name="housetype" id="housetype" placeholder="eg.Villa, Studio, apertment" title="Please enter House Type">
            </div>

            <div class="form-group">
              <label for="name">Description</label>
              <textarea name="description" class="form-control" id="description" cols="3" rows="5" placeholder="Enter your description?" title="Please the description (at least 10 characters)"></textarea>
            </div>
             
             <div class="form-group">
              <label for="name">Size </label>
              <input type="text" class="form-control" name="size" id="size" placeholder="Enter the Size" title="Please enter the Floor">
            </div>

            <div class="form-group">
              <label for="name">Floor </label>
              <input type="text" class="form-control" name="floor" id="floor" placeholder="Enter the floor" title="Please enter the Size">
            </div>

            <div class="form-group">
              <label for="name">Status </label>
              <input type="text" class="form-control" name="Status" id="Status" placeholder="eg.Finished/ half Finished" title="Please enter Finished/ half Finished">
            </div>
              
            <div class="form-group">
              <label for="name">Price </label>
              <input type="text" class="form-control" name="Price" id="Price" placeholder="Price" title="Please enter the Price of the House">
            </div>

              <form action=""  enctype="multipart/form-data">
            <div class="form-group">
              <label for="email">Add Photos</label><br>
              <input type="radio"  name="addPhoto" id="addPhoto" value="Yes" >Yes<br>
              <input type="radio"  name="addPhoto" id="addPhoto" value="No">No<br>
            </div>
              </form>
            <div class="form-group">
              <label for="name">Location </label>
              <input type="text" class="form-control" name="Location" id="Location" placeholder="By Maryam" title="Please enter the Location">
            </div>
    
            <div class="form-group">
              <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">Submit</button>  
            </div>

            <div class="result"></div>
          </div>
        </form>
      </div>
    </div>
    <!--/.container--> 
  </div>
</section>


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
</body>
</html>
