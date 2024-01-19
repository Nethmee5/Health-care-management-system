<%-- 
    Document   : patientsRegister
    Created on : April 21, 2021, 8:50:37 AM
    Author     : vinu
--%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html lang="en">
    <head>
        <title>Patients Registration | Health Shield</title>
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
            /* input[type=text], input[type=password] {
        width: 70%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
      } */

            /* Set a style for all buttons */
            button {
                background-color: #4caf50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 70%;
                opacity: 0.9;
            }

            button:hover {
                opacity: 1;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                background-color: #f44336;
                width: 70%;
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
        <div class="jumbotron">
            <h3>Patients Registration</h3>
            <h5>
                If you do not have an account, create new  account in here
            </h5>
        </div>

        <div class="container">
            <div class="row">


                <div class="col-sm-6" style="background-color: white; align-items:central" >
                    <form action="/app/auth" method="POST" >
                        <div class="container" style="align-items:center; padding-left: 150px;" >
                            <h6 style="color:black;">Fname :</h6> <input
                                type="text"
                                class="form-control"
                                placeholder="First Name"
                                name="fname"
                                required
                                /><br />
                            <h6 style="color:black;">Lname :</h6>
                            <input
                                type="text"
                                class="form-control"
                                placeholder="Last Name"
                                name="lname"
                                required
                                /><br />
                            <h6 style="color:black;">NIC :</h6>
                            <input
                                type="text"
                                class="form-control"
                                placeholder="NIC"
                                name="NIC"
                                required
                                /><br />
                            <h6 style="color:black;">Gender :</h6>
                            <input
                                type="text"
                                class="form-control"
                                placeholder="Gender"
                                name="gender"
                                required
                                /><br />
                            <h6 style="color:black;">Email :</h6>
                            <input
                                type="email"
                                class="form-control"
                                placeholder="Email"
                                name="email"
                                required
                                /><br />
                            <h6 style="color:black;">Phone Number :</h6>
                            <input
                                type="text"
                                class="form-control"
                                placeholder="Contact"
                                name="phone"
                                required
                                /><br />
                            <h6 style="color:black;">Date of Birth :</h6>
                            <input
                                type="Date"
                                class="form-control"
                                placeholder=""
                                name="DOB"
                                aria-describedby="i"
                                required
                                />
                            <small id="timeHelp" class="form-text text-muted"
                                   >Enter date of birth in given format</small
                            >
                            <br />
                            <h6 style="color:black;">Address :</h6>
                            <input
                                type="text"
                                class="form-control"
                                placeholder="Address Line 1"
                                name="add1"
                                required
                                /><br />
                            <input
                                type="text"
                                class="form-control"
                                placeholder="Address Line 2"
                                name="add2"
                                /><br />
                            <h6 style="color:black;">City :</h6>
                            <input
                                type="text"
                                class="form-control"
                                placeholder="City"
                                name="city"
                                required
                                /><br />
                            <h6 style="color:black;">District :</h6>
                            <select class="form-control" name="district" required="true">
                                <option hidden >District</option>
                                <option value="Ampara">Ampara</option>
                                <option value="Anuradhapura">Anuradhapura</option>
                                <option value="Badulla">Badulla</option>
                                <option value="Batticaloa">Batticaloa</option>
                                <option value="Colombo">Colombo</option>
                                <option value="Galle">Galle</option>
                                <option value="Gampaha">Gampaha</option>
                                <option value="Hambantota">Hambantota</option>
                                <option value="Jaffna">Jaffna</option>       
                                <option value="Kalutara">Kalutara</option>
                                <option value="Kandy">Kandy</option>
                                <option value="Kegalle">Kegalle</option>
                                <option value="Kilinochchi">Kilinochchi</option>
                                <option value="Kurunegala">Kurunegala</option>
                                <option value="Mannar">Mannar</option>
                                <option value="Matale">Matale</option>
                                <option value="Matara">Matara</option>
                                <option value="Monaragala">Monaragala</option>
                                <option value="Mulativu">Mulativu</option>
                                <option value="Nuwara Eliya">Nuwara Eliya</option>
                                <option value="Polonnaruwa">Polonnaruwa</option>
                                <option value="Puttalam">Puttalam</option>
                                <option value="Ratnapura">Ratnapura</option>
                                <option value="Trincomalee">Trincomalee</option>
                                <option value="Vavuniya">Vavuniya</option>
                            </select>
                            <br/>
                            <h6 style="color:black;">Postal Code :</h6>
                            <input
                                type="text"
                                class="form-control mt-4"
                                placeholder="Postal Code"
                                name="postal"
                                required
                                /><br />
                            <h6 style="color:black;">Password :</h6>
                            
                            <input
                                type="password"
                                class="form-control"
                                placeholder="password"
                                name="password"
                                required
                                /><br />
                            <input
                                type="hidden"
                                class="form-control"
                                name="role"
                                value="cus"
                                required
                                /><br />
                            <input
                                type="hidden"
                                class="form-control"
                                name="q"
                                value="join"
                                required
                                /><br />
                            
                            <input
                                type="submit"
                                value="Register"
                                class="btn btn-primary btn-block" style="background-color:#1A237E; border:none "
                                />
                            <input
                                type="reset"
                                value="Cancel"
                                class="btn btn-secondary btn-block"
                                />
                        </div>
                    </form>
                </div>
                <div class="col-sm-6" style="background-color: white;">
                    <img src="Images/patrg.jpg" width="600px" height="600px" />
                </div>
            </div>
        </div>
        <br /><br /><br /><br />

        

         <div class="footer" style="background-color:#1A237E;">
            <div class="continer">
                <div class="col-12 py-5" >
                    <p class="text-center my-auto">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved developed by <a href="" target="_blank" style="color:white">Land Marks</a></p>
                </div>
            </div>
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
