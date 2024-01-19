<%-- 
    Document   : adminDashboard
    Created on : April 25, 2021, 8:50:37 AM
    Author     : vinu
--%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>

        <title>Admin Dashboard | Health Shield</title>

        <!--nav-->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i&display=swap" rel="stylesheet">

        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">

        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">

        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/style.css">

        <style>
            .button {
                background-color: rgb(0, 0, 0);
                border: none;
                color: white;
                padding: 5px 45px;
                text-align: center;
                font-size: 16px;
                cursor: pointer;
            }

            .button:hover {
                background-color:rgb(112, 97, 97) ;
            }
        </style>
    </head>

    <body>
        <!-- nav start-->
        <div class="wrap">
            <div class="container">
           
            </div>
        </div>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar" id="ftco-navbar" style="background-color:#1A237E;">
            <div class="container">
                <a class="navbar-brand" href="index.html">Health Shield</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="fa fa-bars"></span> Menu
                </button>
                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a href="index.html" class="nav-link">Home</a></li>
                     

                    </ul>

                </div>
            </div>
        </nav>
        <!-- END nav -->

        <div class="container my-5" style="min-height: 60vh; max-width: 800px;">

            <div class="row">

                <div class="col-12 my-2" style="background-color:white;">       
                    <div class="container btn btn-lg btn-dark">
                        <a href="/app/admin?q=regagent&role=agent">
                            <div class="card-body row">
                                
                                <img class="card-img-top col-4 my-auto" src="Images/2.png" alt="Card image" style="width:300px" style="height:300px" > 
                                <h5 class="col-6 text-light my-auto">New Doctor Adding</h5>
                            </div>
                        </a>
                    </div>
                </div>


                <div class="col-12 my-2" style="background-color:white;">       
                    <div class="container btn btn-lg btn-dark">
                        <a href="/app/admin?q=addService">
                            <div class="card-body row">
                             
                                <img class="card-img-top col-4 my-auto" src="Images/102.png" alt="Card image">
                                <h5 class="col-6 text-light my-auto">Test and medicine Adding</h5>
                            </div>
                        </a>
                    </div>
                </div>


                <div class="col-12 my-2" style="background-color:white;">       
                    <div class="container btn btn-lg btn-dark">
                        <a href="/app/auth?q=leave&role=admin">
                            <div class="card-body row">
                           
                              <img class="card-img-top col-4 my-auto" src="Images/2.png" alt="Card image" style="width:300px" style="height:300px" >
                                <h5 class="col-6 text-light my-auto">Logout</h5>
                            </div>
                        </a>
                    </div>
                </div>


            </div>
        </div>
        

       
        <div class="footer" style="background-color:#1A237E;">
            <div class="continer">
                <div class="col-12 py-5" >
                    <p class="text-center my-auto">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved developed by <a href="" target="_blank" style="color:white">Land Marks</a></p>
                </div>
            </div>
        </div>

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>    
