<%-- 
    Document   : adminAddService
    Created on : April 25, 2021, 4:53:00 PM
    Author     : vinu
--%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>

        <title>Test and Medicine Add | Health Shield</title>
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






            /*form*/

            body {font-family: Arial;}
            * {box-sizing: border-box}

            /* Full-width input fields */
            /* input[type=text], input[type=password] {
              width: 50%;
              padding: 15px;
              margin: 5px 0 22px 0;
              display: inline-block;
              border: none;
              background: #f1f1f1;
            } */



            /* Set a style for all buttons */
            button {
                background-color: rgb(0, 0, 0);
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width:100%;
                opacity: 0.9;
            }

            button:hover {
                opacity:1;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                padding: 14px 20px;
                background-color: #e00031;
            }

            /* Float cancel and signup buttons and add an equal width */
            .cancelbtn, .signupbtn {
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
                .cancelbtn, .signupbtn {
                    width: 50%;
                }
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
        <h2 class="jumbotron" style="line-height: 1px;">Tests and Medicine adding</h2> 
        <div class="container-fluid">

            <div class="row">

                <div class="col-sm-6" style="background-color:white;">    
                    <form action="/app/admin" method="POST" >
                        <div class="container">
                            <select name='type' class="form-control mb-3"required>
                                <option value='test'>Test</option>
                                <option value='medicine'>Medicine</option>
                            </select>
                            <input type="text" class="form-control mb-3" placeholder="Item name" name="name" required>
                            <input type="text" class="form-control mb-3" placeholder="Item brand" name="brand" required>
                            <input type="text" class="form-control mb-3" placeholder="Unite price" name="price" required>
                            <input type="hidden" name="q" value="addService">
                            <input type="hidden" name="role" value="admin">
                            <!-- <h5>Description</h5> -->
                            <textarea id="w3mission" name="desc" class="form-control mb-3" rows="10" cols="60">Description</textarea>
                            <input type="submit" value="Add" class="btn btn-primary btn-block my-2" style="background-color:#1A237E; border: none">
                            <input type="reset" value="Cancel" class="btn btn-secondary btn-block my-2">
                        </div>
                    </form>
                </div>

                <div class="col-sm-6" style="background-color:white;">
                    <img class="card-img-top" src="Images/tee.jpg">
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
