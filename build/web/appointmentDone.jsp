<%-- 
    Document   : appointmentDone
    Created on : April 25, 2021, 6:52:25 PM
    Author     : vinu
--%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Success | Health Shield</title>

        <!--nav-->

        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <link
            href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800,900&display=swap"
            rel="stylesheet"
            />
        <link
            href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i&display=swap"
            rel="stylesheet"
            />

        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />

        <link rel="stylesheet" href="css/animate.css" />

        <link rel="stylesheet" href="css/owl.carousel.min.css" />
        <link rel="stylesheet" href="css/owl.theme.default.min.css" />
        <link rel="stylesheet" href="css/magnific-popup.css" />

        <link rel="stylesheet" href="css/bootstrap-datepicker.css" />
        <link rel="stylesheet" href="css/jquery.timepicker.css" />

        <link rel="stylesheet" href="css/flaticon.css" />
        <link rel="stylesheet" href="css/style.css" />

        <style>
            /*form*/

            body {
                font-family: Arial;
            }
            * {
                box-sizing: border-box;
            }

            /* Full-width input fields */
            input[type="text"],
            input[type="password"] {
                width: 50%;
                padding: 15px;
                margin: 5px 0 22px 0;
                display: inline-block;
                border: none;
                background: #f1f1f1;
            }

            /* Set a style for all buttons */
            button {
                background-color: rgb(0, 0, 0);
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                opacity: 0.9;
            }

            button:hover {
                opacity: 1;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                padding: 14px 20px;
                background-color: #f5294b;
            }

            /* Float cancel and signup buttons and add an equal width */
            .cancelbtn,
            .signupbtn {
                float: left;
                width: 25%;
            }

            /* Clear floats */
            .clearfix::after {
                content: "";
                clear: both;
                display: table;
            }

            /* Change styles for cancel button and signup button on extra small screens */
            @media screen and (max-width: 100px) {
                .cancelbtn,
                .signupbtn {
                    width: 50%;
                }
            }

            /*abox*/

            body {
                color: #444;
            }

            h2 {
                letter-spacing: 0.04em;
                margin: 0;
                font-weight: normal;
                color: #ff5252;
            }

            .announcement {
                width: 80%;
                padding: 10px 15px 0px;
                border: 1px solid #e1e1e1;
                background-color: #f9f9f9;
                border-radius: 4px;
            }

            /*inno box*/

            .div1 {
                width: 150px;
                height: 30px;
                border: 2px solid rgb(7, 7, 31);
            }
        </style>
    </head>
    <body>
        <!-- nav start-->
        <div class="wrap">
            <div class="container">
             
            </div>
        </div>
        <nav
            class="navbar navbar-expand-lg navbar-dark ftco_navbar"
            id="ftco-navbar"
            style="background-color: #1A237E;"
            >
            <div class="container">
                <a class="navbar-brand" href="index.html"
                   >Health Shield</a
                >
                <button
                    class="navbar-toggler"
                    type="button"
                    data-toggle="collapse"
                    data-target="#ftco-nav"
                    aria-controls="ftco-nav"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
                    <span class="fa fa-bars"></span> Menu
                </button>
                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a href="index.html" class="nav-link">Home</a>
                        </li>
                     
                    </ul>
                </div>
            </div>
        </nav>
        <!-- END nav -->

        <div class="container-fluid p-4">
            <div class="row">
                <div class="col-5" style="background-color: white;">
                    <img src="Images/oo3.jpg" width="500px" height="430px" />
                </div>
                <div class="col-6 m-auto" style="background-color: white;">
                    <div class="announcement p-4 my-2">
                        <h4 class="my-4">${msg}</h4>
                        <a href="/app/patientsDashboard.jsp" class="btn btn-lg btn-primary text-light btn-block " style="background-color:#1A237E;">Go to Dashboard</a>
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
        <div id="ftco-loader" class="show fullscreen">
            <svg class="circular" width="48px" height="48px">
            <circle
                class="path-bg"
                cx="24"
                cy="24"
                r="22"
                fill="none"
                stroke-width="4"
                stroke="#eeeeee"
                />
            <circle
                class="path"
                cx="24"
                cy="24"
                r="22"
                fill="none"
                stroke-width="4"
                stroke-miterlimit="10"
                stroke="#F96D00"
                />
            </svg>
        </div>

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

