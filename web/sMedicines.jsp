<%-- 
    Document   : sMedicine
    Created on : April 20, 2021, 6:40:30 PM
    Author     : vinu
--%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Vaccines | Healthcare Logistics</title>
        <!--search-->

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">


        <meta name="viewport" content="width=device-width, initial-scale=1">


        <!--card-->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>




        <!--nav-->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">

        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/style.css">

        <style>

            img {
                opacity: 0.7;
            }



            /*search*/


            body {
                font-family: Arial;
            }

            * {
                box-sizing: border-box;
            }

            form.example input[type=text] {
                padding: 9px;
                font-size: 17px;

                float: left;
                width: 80%;
                background: white;
            }

            form.example button {
                float: left;
                width: 20%;
                padding: 10px;
                background: rgb(6, 7, 8);
                color: white;
                font-size: 17px;
                border: 1px solid  #2196F3;
                border-left: none;
                cursor: pointer;
            }

            form.example button:hover {
                background: #202024;
            }

            form.example::after {
                content: "";
                clear: both;
                display: table;
            }






            body {
                font-family: Arial, Helvetica, sans-serif;
            }

            * {
                box-sizing: border-box;
            }

            /* Create a column layout with Flexbox */
            .row {
                display: flex;
            }

            /* Left column (menu) */
            .left {
                flex: 35%;
                padding: 15px 0;
            }

            .left h2 {
                padding-left: 8px;
            }

            /* Right column (page content) */
            .right {
                flex: 65%;
                padding: 15px;
            }

            /* Style the search box */
            #mySearch {
                width: 100%;
                font-size: 18px;
                padding: 11px;
                border: 1px solid white;
            }


            #myMenu {
                list-style-type: none;
                padding: 0;
                margin: 0;
            }

            #myMenu li a {
                padding: 12px;
                text-decoration: none;
                color: white;

            }

            #myMenu li a:hover {
                background-color: white;
            }
            h7{
                color: rgb(2, 1, 1);
            }

        </style>
    </head>
    <body>
        <!-- nav start-->
        <div class="wrap">
            <div class="container">
               
            </div>

        </div>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar" id="ftco-navbar" style="background-color: #1A237E;">
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


        

        <!--card-->
        <div class="container p-2">
            <p>*Click on the price tag to book a vaccine</p>
        </div>

        <div class="container">

            ${msg}
            <div class="row p-2">

                ${medicineCards}
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
