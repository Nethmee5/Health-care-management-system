<%-- 
    Document   : patientsProfile
    Created on : April 21, 2021, 6:00:18 PM
    Author     : vinu
--%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>


        <title>Profile | Health Shield</title>
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



            body {font-family: Arial, Helvetica, sans-serif;}
            form {border: 3px solid #f1f1f1;}

            input[type=text], input[type=password] {
                width: 60%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            button {
                background-color: rgb(221, 122, 143);
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 60%;
            }

            button:hover {
                opacity: 0.8;
            }


            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
            }

            img.avatar {
                width: 15%;
                border-radius: 5%;
            }


            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }







        </style>
    </head>
    <body>
        <!-- nav start-->
        <div class="wrap">
            <div class="container">
              <!--  <div class="row justify-content-between">
                    <div class="col d-flex align-items-center">
                        <p class="mb-0 phone"><span class="mailus">Idea Seekes</span><span class="mailus">  email developers:</span> <a href="#">Ideaseekers@gmail.com</a></p>
                    </div>

                </div>-->
            </div>

        </div>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar" id="ftco-navbar" style="background-color: #1A237E;">
            <div class="container">
                <a class="navbar-brand" href="index.html">Health Shield<span> LTD</span></a>
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

        <div class="container" style="min-height: 100vh;">
            <h1 class="text-center display-4">Hello <span>${customer.getFname()} ${customer.getLname()}</span></h1>
            <h2><center>Have a nice day</center></h2>
            <div class="row text-center p-4 my-3 my-auto">

              

                <div class="jumbotron container col-8 my-auto">
                    <h5 class="text-dark text-left">Name: ${customer.getFname()} ${customer.getLname()}</h5>
                    <h5 class="text-dark text-left">Email: ${customer.getEmail()}</h5>
                    <h5 class="text-dark text-left">NIC: ${customer.getNIC()}</h5>
                    <h5 class="text-dark text-left">Contact: ${customer.getPhone()}</h5>
                    <h5 class="text-dark text-left">Address: ${customer.getAdLine1()} ${customer.getAdLine2()}, ${customer.getCity()}, ${customer.getPostalCode()}</h5>
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
